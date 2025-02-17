package com.thecoderstv.hotelservice.exceptions;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class ApiResponse {
    private String message;
    private String request;
}
