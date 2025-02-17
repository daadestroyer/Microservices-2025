package com.thecoderstv.userservice.service.impl;

import com.thecoderstv.userservice.entities.User;
import com.thecoderstv.userservice.exceptions.ResourceNotFoundException;
import com.thecoderstv.userservice.repo.UserRepo;
import com.thecoderstv.userservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepo userRepo;

    @Override
    public User saveUser(User user) {
        user.setUserId(UUID.randomUUID().toString());
        return this.userRepo.save(user);
    }

    @Override
    public Optional<User> getUser(String userId) {
        return this.userRepo.findById(userId);
    }

    @Override
    public List<User> getAllUser() {
        return this.userRepo.findAll();
    }

    @Override
    public String deleteUser(String userId) {
        User user = this
                .userRepo
                .findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User with id " + userId + " not found"));
        userRepo.delete(user);
        return "User " + userId + " deleted";
    }
}
