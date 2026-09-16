package application.command.user;

import java.time.LocalDate;

public class CreateUserCommand {
    private final String name;
    private final String email;
    private final LocalDate birthDate;

    public CreateUserCommand(String name, String email, LocalDate birthDate) {
        this.name = name;
        this.email = email;
        this.birthDate = birthDate;
    }

    public String getName() { return name; }
    public String getEmail() { return email; }
    public LocalDate getBirthDate() { return birthDate; }
}