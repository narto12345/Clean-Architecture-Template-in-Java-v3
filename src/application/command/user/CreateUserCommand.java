package application.command.user;

import java.time.LocalDate;

import application.mediator.Command;
import domain.result.Result;

public class CreateUserCommand implements Command<Result<CreateUserResponse>> {
    private final String name;
    private final String email;
    private final LocalDate birthDate;

    public CreateUserCommand(String name, String email, LocalDate birthDate) {
        this.name = name;
        this.email = email;
        this.birthDate = birthDate;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }
}
