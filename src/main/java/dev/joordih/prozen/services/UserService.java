package dev.joordih.prozen.services;

import dev.joordih.prozen.managers.models.impl.user.User;
import java.util.List;

public interface UserService {
    List<User> findAll();
    User findById(String id);
    User findByUsername(String username);
    User findByEmail(String email);
    User create(User user);
    User update(String id, User user);
    void delete(String id);
}
