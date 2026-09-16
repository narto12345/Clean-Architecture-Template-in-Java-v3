import java.time.LocalDate;

import Infrastructure.repository.FictitiousUserRepository;
import application.command.user.CreateUserCommand;
import application.usecase.user.CreateUserUseCase;
import domain.model.User;
import domain.repository.UserRepository;
import domain.result.Result;

public class App {
    public static void main(String[] args) {
        UserRepository repository = new FictitiousUserRepository();
        CreateUserUseCase useCase = new CreateUserUseCase(repository);

        CreateUserCommand userCommand = new CreateUserCommand(
                "viviana",
                "santi@hotmail.com",
                LocalDate.of(1990, 2, 18));

        Result<User> result = useCase.execute(userCommand);

        if (!result.isSuccess()) {
            System.out.println(result.getNotification().getErrors());
        }

        if (result.isSuccess()) {
            System.out.println("User created: " + result.getValue());
        }
    }
}
