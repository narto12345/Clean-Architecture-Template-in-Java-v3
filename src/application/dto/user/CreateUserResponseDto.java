package application.dto.user;

import java.time.LocalDate;

public record CreateUserResponseDto(String id, String name, String email, LocalDate birthDate) {}