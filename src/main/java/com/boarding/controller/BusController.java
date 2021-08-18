package com.boarding.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.boarding.entity.Bus;
import com.boarding.service.BusService;

@RestController
@CrossOrigin
@RequestMapping("api/v1")
public class BusController {

	@Autowired
	BusService busService;

	@GetMapping("/bus/{busID}")
	public Optional<Bus> getBusByID(@PathVariable Long busID) {
		return this.busService.getBusByID(busID);
	}

	@GetMapping("/bus/all")
	public List<Bus> getAllBuses() {
		return busService.getAllBuses();
	}
}
