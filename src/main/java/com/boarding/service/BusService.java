package com.boarding.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.boarding.entity.Bus;
import com.boarding.respository.BusRepository;

@Service
public class BusService {
	@Autowired
	BusRepository busRepository;

	public Bus getBusByID(Long busID) throws Exception {
		return busRepository.findById(busID).orElseThrow(() -> new Exception("Not Found"));
	}
	
	public List<Bus> getAllBuses(){
		return busRepository.findAll();
	}
}
