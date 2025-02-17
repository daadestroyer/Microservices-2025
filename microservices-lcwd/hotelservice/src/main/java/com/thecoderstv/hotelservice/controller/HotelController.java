package com.thecoderstv.hotelservice.controller;

import com.thecoderstv.hotelservice.entities.Hotel;
import com.thecoderstv.hotelservice.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/hotel")
public class HotelController {

    @Autowired
    private HotelService hotelService;

    @PostMapping
    public ResponseEntity<?> saveHotel(@RequestBody Hotel hotel) {
        Hotel savedHotel = hotelService.saveHotel(hotel);
        return new ResponseEntity<>(savedHotel, HttpStatus.CREATED);
    }

    @GetMapping("/{hotelId}")
    public ResponseEntity<?> getHotel(@PathVariable("hotelId") String hotelId) {
        Optional<Hotel> optionalHotel = hotelService.getHotel(hotelId);
        if (optionalHotel.isPresent()) {
            return new ResponseEntity<>(optionalHotel.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>("Hotel " + hotelId + " not found", HttpStatus.NOT_FOUND);
    }

    @GetMapping
    public ResponseEntity<?> getAllHotel() {
        List<Hotel> allHotel = hotelService.getAllHotel();
        if (!allHotel.isEmpty()) {
            return new ResponseEntity<>(allHotel, HttpStatus.OK);
        }
        return new ResponseEntity<>("No hotel found ", HttpStatus.NOT_FOUND);
    }
}
