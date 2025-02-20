package com.thecoderstv.userservice.external.service;

import com.thecoderstv.userservice.entities.Ratings;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient(name = "RATING-SERVICE")
public interface RatingServiceFeign {
    @PostMapping("/rating")
    public Ratings createRating(Ratings ratings);

    @DeleteMapping("/{ratingId}")
    public void deleteRating(@PathVariable("ratingId") String ratingId);

}
