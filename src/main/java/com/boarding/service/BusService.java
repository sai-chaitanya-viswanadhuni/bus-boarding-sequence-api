package com.boarding.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.boarding.entity.Bus;
import com.boarding.respository.BusRepository;

@Service
public class BusService {
	@Autowired
	BusRepository busRepository;

	public Optional<Bus> getBusByID(Long busID) {
		return busRepository.findById(busID);
	}
	
	public List<Bus> getAllBuses(){
		return busRepository.findAll();
	}
}
