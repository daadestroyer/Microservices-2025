package com.thecoderstv.hotelservice.service.impl;

import com.thecoderstv.hotelservice.entities.Hotel;
import com.thecoderstv.hotelservice.exceptions.ResourceNotFoundException;
import com.thecoderstv.hotelservice.repo.HotelRepo;
import com.thecoderstv.hotelservice.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class HotelServiceImpl implements HotelService {

    @Autowired
    private HotelRepo hotelRepo;

    @Override
    public Hotel saveHotel(Hotel hotel) {
        hotel.setHotelId(UUID.randomUUID().toString());
        return hotelRepo.save(hotel);
    }

    @Override
    public Optional<Hotel> getHotel(String hotelId) {
        return hotelRepo.findById(hotelId);
    }

    @Override
    public List<Hotel> getAllHotel() {
        return hotelRepo.findAll();
    }

    @Override
    public String deleteHotel(String hotelId) {
        Hotel hotel = hotelRepo.findById(hotelId).orElseThrow(() -> new ResourceNotFoundException("Hotel " + hotelId + " not found"));
        hotelRepo.delete(hotel);
        return "Hotel Deleted...";
    }
}
