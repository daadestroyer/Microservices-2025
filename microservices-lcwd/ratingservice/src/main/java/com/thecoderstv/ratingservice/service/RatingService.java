package com.thecoderstv.ratingservice.service;

import com.thecoderstv.ratingservice.entities.Rating;

import java.util.List;
import java.util.Optional;

public interface RatingService {
    Rating saveRating(Rating rating);

    Optional<Rating> getRatingByRatingId(String ratingId);

    List<Rating> getAlRatings();

    List<Rating> getAllRatingByUserId(String userId);
    List<Rating> getAllRatingByHotelId(String hotelId);

    String deleteRating(String ratingId);
}
