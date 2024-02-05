package org.dyalex.spring_boot.service;

import org.dyalex.spring_boot.model.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    Optional<User> findById(Long id);
    List<User> findAll();
    void saveUser(User user);
    void deleteById(Long id);
}
