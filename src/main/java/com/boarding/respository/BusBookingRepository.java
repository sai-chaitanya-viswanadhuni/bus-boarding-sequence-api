package com.boarding.respository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.boarding.entity.Bus;
import com.boarding.entity.BusBooking;

@Repository
public interface BusBookingRepository extends JpaRepository<BusBooking, Long> {

	List<BusBooking> findByBus(Bus bus);
}
