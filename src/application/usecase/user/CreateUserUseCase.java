package application.usecase.user;

import java.util.UUID;

import application.command.user.CreateUserCommand;
import application.command.user.CreateUserResponse;
import domain.model.User;
import domain.repository.UserRepository;
import domain.result.Notification;
import domain.result.Result;
import domain.result.user.UserError;
import domain.validation.user.UserValidator;
import application.mediator.CommandHandler;

public class CreateUserUseCase implements CommandHandler<CreateUserCommand, Result<CreateUserResponse>> {
    private final UserRepository userRepository;

    public CreateUserUseCase(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public Result<CreateUserResponse> handle(CreateUserCommand command) {
        User user = new User(UUID.randomUUID().toString(),
                command.getName(),
                command.getEmail(),
                command.getBirthDate());

        Notification notification = UserValidator.validate(user);

        if (notification.hasErrors()) {
            return Result.failure(notification);
        }

        Result<User> resultFindByEmailResult = userRepository.findByEmail(command.getEmail());
        if (resultFindByEmailResult.isFailure()) {
            return Result.failure(resultFindByEmailResult.getNotification());
        }

        if (resultFindByEmailResult.getValue() != null) {
            return Result.failure(UserError.EMAIL_ALREADY_EXISTS);
        }

        Result<User> resultUserSave = userRepository.save(user);
        if (resultUserSave.isFailure()) {
            return Result.failure(resultUserSave.getNotification());
        }
        
        return Result.success(new CreateUserResponse(resultUserSave.getValue()));
    }
}