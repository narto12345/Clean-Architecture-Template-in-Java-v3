package application.dto.user;

import java.time.LocalDate;

import domain.model.User;

public class CreateUserRequestDto {
    private final String name;
    private final String email;
    private final LocalDate birthDate;

    public CreateUserRequestDto(String name, String email, LocalDate birthDate) {
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

    public User toDomain() {
        return new User(this.name, this.email, this.birthDate);
    }
}
