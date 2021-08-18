package com.boarding.respository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.boarding.entity.BusRoute;

@Repository
public interface BusRouteRepository extends JpaRepository<BusRoute, Long> {

}
