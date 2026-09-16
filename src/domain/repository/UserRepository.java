package domain.repository;

import domain.model.User;
import domain.result.Result;

public interface UserRepository {
    Result<User> save(User user);
    Result<User> findByEmail(String email);
}