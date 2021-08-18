package com.boarding.respository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.boarding.entity.BusSeat;

@Repository
public interface BusSeatRepository extends JpaRepository<BusSeat, Long> {

}
