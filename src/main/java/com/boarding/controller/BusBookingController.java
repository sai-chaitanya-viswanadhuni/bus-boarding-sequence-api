package com.boarding.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.boarding.DTO.BusBookingDTO;
import com.boarding.entity.BusBooking;
import com.boarding.service.BusBookingService;

@RestController
@RequestMapping(value = "api/v1")
@CrossOrigin
public class BusBookingController {

	@Autowired
	BusBookingService busBookingService;

	@PostMapping("bus/book/tickets")
	public String bookBusTickets(@RequestBody BusBookingDTO busBookingDetails) throws Exception {
		System.out.println(busBookingDetails.toString());
		return busBookingService.bookBusTickets(busBookingDetails);
	}

	@GetMapping("bus/booking/{bookingID}")
	public Optional<BusBooking> getBusBookingDetailsByBookingID(@PathVariable Long bookingID) {
		System.out.println("In Controller");
		System.out.println(busBookingService.getBusBookingDetailsByBookingID(bookingID));
		return busBookingService.getBusBookingDetailsByBookingID(bookingID);
	}
	
	@GetMapping("bus/bookings/all/{busID}")
	public List<BusBooking> getAllBusBookingsByBusID(@PathVariable Long busID) throws Exception {
		return busBookingService.getAllBusBookingsByBusID(busID);
	}
	
	@GetMapping("bus/booking/all")
	public List<BusBooking> getAllBusBookings(){
		return busBookingService.getAllBusBookings();
	}
}
