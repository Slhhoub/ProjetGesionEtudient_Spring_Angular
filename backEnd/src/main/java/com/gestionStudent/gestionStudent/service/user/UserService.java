package com.gestionStudent.gestionStudent.service.user;

import com.gestionStudent.gestionStudent.entity.User;

import java.util.List;
import java.util.Optional;

public interface UserService {

    List<User> getAllUser();

    Optional<User> getUserById(Integer id);

    void deleteUser(Integer id);

    User updateUser(User user,Integer id);
}
