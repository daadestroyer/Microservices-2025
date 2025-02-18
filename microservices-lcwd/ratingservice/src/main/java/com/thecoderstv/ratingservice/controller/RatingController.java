package com.thecoderstv.ratingservice.controller;

import com.thecoderstv.ratingservice.entities.Rating;
import com.thecoderstv.ratingservice.service.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/rating")
public class RatingController {
    @Autowired
    private RatingService ratingService;

    @PostMapping
    public ResponseEntity<?> saveRating(@RequestBody Rating rating) {
        Rating savedRating = ratingService.saveRating(rating);
        return new ResponseEntity<>(savedRating, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<?> getAllRating() {
        List<Rating> allRatings = ratingService.getAlRatings();
        return new ResponseEntity<>(allRatings, HttpStatus.OK);
    }

    @GetMapping("/rating-id/{ratingId}")
    public ResponseEntity<?> getRatingByRatingId(@PathVariable("ratingId") String ratingId) {
        Optional<Rating> optionalRating = ratingService.getRatingByRatingId(ratingId);
        if (optionalRating.isPresent()) {
            return new ResponseEntity<>(optionalRating.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>("No ratings details found with rating id " + ratingId, HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/hotel-id/{hotelId}")
    public ResponseEntity<?> getRatingByHotelId(@PathVariable("hotelId") String hotelId) {
        List<Rating> allRatingByHotelId = ratingService.getAllRatingByHotelId(hotelId);
        if (!allRatingByHotelId.isEmpty()) {
            return new ResponseEntity<>(allRatingByHotelId, HttpStatus.OK);
        } else {
            return new ResponseEntity<>("No data found", HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/user-id/{userId}")
    public ResponseEntity<?> getRatingByUserId(@PathVariable("userId") String userId) {
        List<Rating> allRatingByUserId = ratingService.getAllRatingByUserId(userId);
        if (!allRatingByUserId.isEmpty()) {
            return new ResponseEntity<>(allRatingByUserId, HttpStatus.OK);
        } else {
            return new ResponseEntity<>("No data found", HttpStatus.NOT_FOUND);
        }
    }
}
