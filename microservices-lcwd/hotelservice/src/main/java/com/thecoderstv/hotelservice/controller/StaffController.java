package com.thecoderstv.hotelservice.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/staff")
public class StaffController {
    @GetMapping
    public ResponseEntity<?> getStaff(){
        List<String> staffList = Arrays.asList("ram", "shyam", "ghanshyam");
        return new ResponseEntity<>(staffList, HttpStatus.OK);
    }
}
