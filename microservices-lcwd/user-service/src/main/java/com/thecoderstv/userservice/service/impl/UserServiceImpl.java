package com.thecoderstv.userservice.service.impl;

import com.thecoderstv.userservice.entities.Hotel;
import com.thecoderstv.userservice.entities.Ratings;
import com.thecoderstv.userservice.entities.User;
import com.thecoderstv.userservice.exceptions.ResourceNotFoundException;
import com.thecoderstv.userservice.repo.UserRepo;
import com.thecoderstv.userservice.service.UserService;
import org.apache.juli.logging.Log;
import org.apache.juli.logging.LogFactory;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.*;
import java.util.logging.Logger;
import java.util.stream.Collectors;

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
        // api call to rating service
        String ratingUrl = "http://RATING-SERVICE/rating/user-id/" + userId;
        Ratings[] ratingsArray = restTemplate.getForObject(ratingUrl, Ratings[].class);
        List<Ratings> ratingsOfUser = Arrays.asList(ratingsArray);

        // user.setRatings(ratingsOfUser);
        List<Ratings> ratingsListIncludingHotel = ratingsOfUser.stream().map(rating -> {
            // api call to hotel service
            String hotelUrl = "http://HOTEL-SERVICE/hotel/" + rating.getHotelId();
            Hotel hotel = restTemplate.getForEntity(hotelUrl, Hotel.class).getBody();

            // set the hotel to rating
            rating.setHotel(hotel);

            // return the rating
            return rating;
        }).collect(Collectors.toList());
        user.setRatings(ratingsListIncludingHotel);
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
