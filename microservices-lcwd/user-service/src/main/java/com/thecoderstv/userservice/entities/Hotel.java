package com.thecoderstv.userservice.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Hotel {
    private String hotelId;
    private String name;
    private String location;
    private String about;
}
