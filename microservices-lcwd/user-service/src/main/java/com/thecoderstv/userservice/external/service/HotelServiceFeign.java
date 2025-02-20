package com.thecoderstv.userservice.external.service;


import com.thecoderstv.userservice.entities.Hotel;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@FeignClient(name = "HOTEL-SERVICE")
public interface HotelServiceFeign {
    @GetMapping("/hotel/{hotelId}")
    public Hotel getHotelByHotelId(@PathVariable String hotelId);
}
