package com.thecoderstv.hotelservice.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class Hotel {
    @Id
    private String hotelId;
    private String name;
    private String location;
    private String about;
}
