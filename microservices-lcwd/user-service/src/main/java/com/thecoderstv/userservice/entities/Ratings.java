package com.thecoderstv.userservice.entities;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Ratings {
    private String ratingId;
    private String userId;
    private String hotelId;
    private String rating;
    private String remarks;
    private Hotel hotel;

}
