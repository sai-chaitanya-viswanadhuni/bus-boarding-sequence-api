package com.boarding.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "BUS_ROUTE")
public class BusRoute {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer busRouteId;

	private String source;

	private String destination;

	private Long distace;

	public Integer getRouteId() {
		return busRouteId;
	}

	public void setRouteId(Integer routeId) {
		this.busRouteId = routeId;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public Long getDistace() {
		return distace;
	}

	public void setDistace(Long distace) {
		this.distace = distace;
	}

	@Override
	public String toString() {
		return "BusRoute [routeId=" + busRouteId + ", source=" + source + ", destination=" + destination + ", distace="
				+ distace + "]";
	}

}
