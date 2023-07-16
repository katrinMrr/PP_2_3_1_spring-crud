package springBoot.service;

import springBoot.model.User;

import java.util.List;

public interface UserService {
    void saveOrUpdate(User user);

    void deleteUser(Long id);

    User getUserById(Long id);

   List<User> getAllUsers();
}
