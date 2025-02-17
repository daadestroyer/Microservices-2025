package com.thecoderstv.hotelservice.service;

import com.thecoderstv.hotelservice.entities.Hotel;

import java.util.List;
import java.util.Optional;

public interface HotelService {
    Hotel saveHotel(Hotel hotel);

    Optional<Hotel> getHotel(String hotelId);

    List<Hotel> getAllHotel();

    String deleteHotel(String hotelId);
}
