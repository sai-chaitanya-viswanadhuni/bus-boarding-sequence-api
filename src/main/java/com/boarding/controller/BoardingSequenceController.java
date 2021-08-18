package com.boarding.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.boarding.entity.Bus;
import com.boarding.entity.BusBooking;
import com.boarding.respository.BusBookingRepository;
import com.boarding.respository.BusRepository;
import com.boarding.utils.BoardingSequenceFinder;

@RestController
@RequestMapping(value = "api/v1")
@CrossOrigin
public class BoardingSequenceController {

	@Autowired
	BusBookingRepository busBookingRepository;

	@Autowired
	BusRepository busRepository;

	@Autowired
	BoardingSequenceFinder boardingSequenceFinder;

	@GetMapping("/getBoardingSequence/{busID}")
	public ArrayList<Integer> generateBoardingSequence(@PathVariable Long busID) {
		Bus bus = new Bus();
		bus = busRepository.findById(busID).orElseThrow();
		List<BusBooking> busBookingList = busBookingRepository.findByBus(bus);
		return boardingSequenceFinder.findSequence(busBookingList);
	}
}
