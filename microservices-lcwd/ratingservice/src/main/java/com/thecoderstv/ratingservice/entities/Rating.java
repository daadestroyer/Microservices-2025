package com.thecoderstv.ratingservice.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
public class Rating{
    @Id
    private String ratingId;
    private String userId;
    private String hotelId;
    private String rating;
    private String remarks;

}
