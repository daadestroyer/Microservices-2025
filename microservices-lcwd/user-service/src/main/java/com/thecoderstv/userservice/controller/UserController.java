package com.thecoderstv.userservice.controller;

import com.thecoderstv.userservice.entities.User;
import com.thecoderstv.userservice.service.UserService;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/user")
@Slf4j
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseEntity<?> saveUser(@RequestBody User user) {
        User savedUser = userService.saveUser(user);
        return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
    }

    int retryCount = 1;
    @GetMapping("/{userId}")
//    @CircuitBreaker(name = "ratingHotelBreaker", fallbackMethod = "ratingHotelFallback")
    @Retry(name="ratingHotelService",fallbackMethod = "ratingHotelFallback")
    public ResponseEntity<?> getUser(@PathVariable String userId) {
        // this api is calling internally rating service and hotel service
        log.info("Retry Count : "+retryCount);
        retryCount++;
        User user = userService.getUser(userId);
        if (user != null) {
            return new ResponseEntity<>(user, HttpStatus.OK);
        }
        return new ResponseEntity<>("User " + userId + " not found ", HttpStatus.NOT_FOUND);
    }

    // ratingHotelFallback method for circuit breaker

    public ResponseEntity<?> ratingHotelFallback(String userId, Exception ex) {
        log.info("Fallback method executed because Rating Service is down : " + ex.getMessage());

        User dummy = User
                .builder()
                .email("dummy@gmail.com")
                .name("dummy")
                .about("dummy user because some service is down")
                .userId("1234").build();
        return new ResponseEntity<>(dummy, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<?> getAllUser() {
        List<User> allUser = userService.getAllUser();
        if (!allUser.isEmpty()) {
            return new ResponseEntity<>(allUser, HttpStatus.OK);
        }
        return new ResponseEntity<>("No user found", HttpStatus.NOT_FOUND);
    }

}
