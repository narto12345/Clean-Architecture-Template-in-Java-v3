import java.time.LocalDate;

import Infrastructure.repository.FictitiousUserRepository;
import application.command.user.CreateUserCommand;
import application.command.user.CreateUserResponse;
import application.mediator.SimpleMediator;
import application.usecase.user.CreateUserUseCase;
import domain.repository.UserRepository;
import domain.result.Result;

public class App {
    public static void main(String[] args) {
        UserRepository repository = new FictitiousUserRepository();
        CreateUserUseCase useCase = new CreateUserUseCase(repository);

        SimpleMediator mediator = new SimpleMediator();

        mediator.register(CreateUserCommand.class, useCase);

        CreateUserCommand userCommand = new CreateUserCommand(
                "nicolas",
                "nicosan12@hotmail.com",
                LocalDate.of(2000, 2, 18));

        Result<CreateUserResponse> result = mediator.send(userCommand);

        if (!result.isSuccess()) {
            System.out.println(result.getNotification().getErrors());
        }

        if (result.isSuccess()) {
            System.out.println("User created: " + result.getValue());
        }
    }
}
