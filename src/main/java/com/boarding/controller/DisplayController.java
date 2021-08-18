package com.boarding.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class DisplayController {

	@GetMapping("/")
	public String displayStartupPage() {
		return "This is Bus Booking Boarding Sequence Generator Application";
	}

	@GetMapping("/welcome")
	public String displayeWelcomeMessage() {
		return "Welcome Here";
	}
	
}
