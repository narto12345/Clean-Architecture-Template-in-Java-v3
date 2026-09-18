package application.command.user;

import application.dto.user.CreateUserRequestDto;
import application.mediator.Command;
import domain.model.User;
import domain.result.Result;

public class CreateUserCommand implements Command<Result<CreateUserResponse>> {

    private final CreateUserRequestDto request;

    public CreateUserCommand(CreateUserRequestDto request) {
        this.request = request;
    }

    public CreateUserRequestDto getRequest() {
        return this.request;
    }

    public User toDomain() {
        return User.createNew(request.getName(), request.getEmail(), request.getBirthDate());
    }
}