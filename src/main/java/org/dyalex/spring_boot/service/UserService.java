package org.dyalex.spring_boot.service;

import org.dyalex.spring_boot.model.User;

import java.util.List;

public interface UserService {
    User findById(Long id);
    List<User> findAll();
    User saveUser(User user);
    void deleteById(Long id);
}
