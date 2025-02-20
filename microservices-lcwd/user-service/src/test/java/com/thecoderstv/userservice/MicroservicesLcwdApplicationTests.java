package com.thecoderstv.userservice;

import com.thecoderstv.userservice.entities.Ratings;
import com.thecoderstv.userservice.external.service.RatingServiceFeign;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class MicroservicesLcwdApplicationTests {

	@Autowired
	private RatingServiceFeign ratingServiceFeign;

	@Test
	void contextLoads() {
	}

	@Test
	public void createRatingFromUser(){
		Ratings ratings = Ratings
				.builder()
				.userId("50b0a642-1d2f-4122-a9cd-536d6d222db7")
				.hotelId("c18b4909-df39-4865-8d49-d858a5e46de7")
				.rating("10")
				.remarks("Good hotel").build();

		ratingServiceFeign.createRating(ratings);
		System.out.println("Rating Created----------");
	}
}
