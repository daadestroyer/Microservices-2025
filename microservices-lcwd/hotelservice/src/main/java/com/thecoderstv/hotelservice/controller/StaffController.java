package com.thecoderstv.hotelservice.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/staff")
public class StaffController {

    private static HashMap<String, String> staffList = new HashMap<>();

    static {
        staffList.put("1", "Ram");
        staffList.put("2", "Shyam");
        staffList.put("3", "Ramesh");
    }

    @GetMapping
    public ResponseEntity<?> getStaff() {
        return new ResponseEntity<>(staffList, HttpStatus.OK);
    }

    @GetMapping("/{staffId}")
    public ResponseEntity<?> getStaffById(@PathVariable("staffId") String staffId) {
        if (staffList.containsKey(staffId)) {
            return new ResponseEntity<>(staffList.get(staffId), HttpStatus.OK);
        }
        return new ResponseEntity<>("No staff found with id "+staffId,HttpStatus.OK);
    }
}
