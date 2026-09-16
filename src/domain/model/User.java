package domain.model;

import java.time.LocalDate;
import java.time.Period;

public class User {
    private final String id;
    private final String name;
    private final String email;
    private final LocalDate birthDate;

    public User(String id, String name, String email, LocalDate birthDate) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.birthDate = birthDate;
    }

    public String getId() {
        return id;
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

    public boolean isUnderage() {
        return Period.between(birthDate, LocalDate.now()).getYears() < 18;
    }

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", birthDate=" + birthDate +
                '}';
    }
}