package infrastructure.repository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import domain.model.User;
import domain.repository.UserRepository;
import domain.result.Result;
import domain.result.user.UserError;

public class FictitiousUserRepository implements UserRepository {
    private final List<User> users = new ArrayList<>(Arrays.asList(
            User.createNew("nico", "nicosan12@hotmail.com", LocalDate.now()),
            User.createNew("pedro", "pedro@hotmail.com", LocalDate.now()),
            User.createNew("juan", "juan@hotmail.com", LocalDate.now())));

    @Override
    public Result<User> save(User user) {

        if ("viviana".equals(user.getName())) {
            return Result.failure(UserError.CREATION_FAILED);
        }

        users.add(user);
        return Result.success(user);
    }

    @Override
    public Result<User> findByEmail(String email) {
        Optional<User> userFound = users.stream().filter(user -> user.getEmail().equals(email)).findFirst();
        return Result.success(userFound.orElse(null));
    }
}
