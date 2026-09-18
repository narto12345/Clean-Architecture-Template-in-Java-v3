package application.command.user;

import application.dto.user.CreateUserRequestDto;
import application.mediator.Command;
import domain.result.Result;

public class CreateUserCommand implements Command<Result<CreateUserResponse>> {

    private CreateUserRequestDto request;

    public CreateUserCommand(CreateUserRequestDto request) {
        this.request = request;
    }

    public CreateUserRequestDto getCreateUser() {
        return request;
    }
}