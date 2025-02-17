package com.thecoderstv.userservice.service;

import com.thecoderstv.userservice.entities.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    User saveUser(User user);

    Optional<User> getUser(String userId);

    List<User> getAllUser();

    String deleteUser(String userId);
}
