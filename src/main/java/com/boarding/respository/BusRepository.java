package com.boarding.respository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.boarding.entity.Bus;

@Repository
public interface BusRepository extends JpaRepository<Bus, Long> {
}
