package domain.model;

import java.time.LocalDate;
import java.time.Period;
import java.util.UUID;

public class User {
    private String id;
    private String name;
    private String email;
    private LocalDate birthDate;

    private User(String id, String name, String email, LocalDate birthDate) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.birthDate = birthDate;
    }

    public static User createNew(String name, String email, LocalDate birthDate) {
        return new User(UUID.randomUUID().toString(), name, email, birthDate);
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