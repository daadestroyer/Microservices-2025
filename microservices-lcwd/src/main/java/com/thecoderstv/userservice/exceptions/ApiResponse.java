package com.thecoderstv.userservice.exceptions;

import lombok.*;
import org.springframework.http.HttpStatus;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class ApiResponse {
    private String message;
    private String request;
}
