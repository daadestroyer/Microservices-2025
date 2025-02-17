package com.thecoderstv.userservice.entities;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Transient;
import lombok.*;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class User {
    @Id
    private String userId;
    private String name;
    private String email;
    private String about;

    @Transient // i don't want to save this into DB
    private List<Ratings> ratings;

}
