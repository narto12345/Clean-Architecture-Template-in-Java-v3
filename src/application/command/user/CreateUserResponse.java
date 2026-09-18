package application.command.user;

import application.dto.user.CreateUserResponseDto;
import domain.model.User;

public record CreateUserResponse(CreateUserResponseDto response) {

    public static CreateUserResponse fromDomain(User user) {
        CreateUserResponseDto createUserResponseDto = new CreateUserResponseDto(user.getId(), user.getName(), user.getEmail(), user.getBirthDate());
        return new CreateUserResponse(createUserResponseDto);
    }
    
}