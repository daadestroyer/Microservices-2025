package com.thecoderstv.userservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class UserserviceLcwdApplication {


	public static void main(String[] args) {
		SpringApplication.run(UserserviceLcwdApplication.class, args);
	}

}
