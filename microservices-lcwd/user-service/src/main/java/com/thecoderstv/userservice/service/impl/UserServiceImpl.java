package com.thecoderstv.userservice.service.impl;

import com.thecoderstv.userservice.entities.Ratings;
import com.thecoderstv.userservice.entities.User;
import com.thecoderstv.userservice.exceptions.ResourceNotFoundException;
import com.thecoderstv.userservice.repo.UserRepo;
import com.thecoderstv.userservice.service.UserService;
import org.apache.juli.logging.Log;
import org.apache.juli.logging.LogFactory;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.logging.Logger;

@Service
public class UserServiceImpl implements UserService {

    private static final Log logger = LogFactory.getLog(UserServiceImpl.class);
    @Autowired
    private UserRepo userRepo;

    @Autowired
    private RestTemplate restTemplate;

    @Override
    public User saveUser(User user) {
        user.setUserId(UUID.randomUUID().toString());
        return this.userRepo.save(user);
    }

    @Override
    public User getUser(String userId) {
        User user = this.userRepo.findById(userId).get();
        //
        String url = "http://localhost:8083/rating/user-id/"+userId;
        ArrayList<Ratings> ratingsOfUser = restTemplate.getForObject(url, ArrayList.class);
        user.setRatings(ratingsOfUser);
        return user;

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
