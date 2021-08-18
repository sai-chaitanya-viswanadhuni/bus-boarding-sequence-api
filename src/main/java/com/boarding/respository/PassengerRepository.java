package com.boarding.respository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.boarding.entity.Passenger;

@Repository
public interface PassengerRepository extends JpaRepository<Passenger, Long>{

}
