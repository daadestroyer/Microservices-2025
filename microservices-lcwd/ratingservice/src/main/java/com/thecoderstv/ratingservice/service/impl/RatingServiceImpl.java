package com.thecoderstv.ratingservice.service.impl;

import com.thecoderstv.ratingservice.entities.Rating;
import com.thecoderstv.ratingservice.repo.RatingRepo;
import com.thecoderstv.ratingservice.service.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class RatingServiceImpl implements RatingService {

    @Autowired
    private RatingRepo ratingRepo;

    @Override
    public Rating saveRating(Rating rating) {
        rating.setRatingId(UUID.randomUUID().toString());
        return ratingRepo.save(rating);
    }

    @Override
    public Optional<Rating> getRatingByRatingId(String ratingId) {
        return ratingRepo.findById(ratingId);
    }

    @Override
    public List<Rating> getAlRatings() {
        return ratingRepo.findAll();
    }

    @Override
    public List<Rating> getAllRatingByUserId(String userId) {
        return ratingRepo.findByUserId(userId);
    }

    @Override
    public List<Rating> getAllRatingByHotelId(String hotelId) {
        System.out.println("Rating by hotel id "+ratingRepo.findByHotelId(hotelId));
         return ratingRepo.findByHotelId(hotelId);
    }

    @Override
    public String deleteRating(String ratingId) {
        return null;
    }
}
