package com.boarding.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Bus {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long busId;

	@Column(name = "BUS_NAME")
	private String busName;

	@Column(name = "PLATE_NAME")
	private String plateName;

	@Column(name = "SEATS_BOOKED")
	private int seatsbooked;

	@Column(name = "TOTAL_SEATS")
	private int totalSeats;

	@Column(name = "START_TIME")
	private Date dailyStartTime;

	@Column(name = "STOP_TIME")
	private Date dailyStopTime;

	@Column(name = "BUS_TYPE")
	private String busType;

	@Column(name = "TICKET_FARE")
	private String fare;

	@ManyToOne
	@JoinColumn(name = "BUS_ROUTE_ID")
	private BusRoute busRoute;

	public Long getBusId() {
		return busId;
	}

	public void setBusId(Long busId) {
		this.busId = busId;
	}

	public String getBusName() {
		return busName;
	}

	public void setBusName(String busName) {
		this.busName = busName;
	}

	public String getPlateName() {
		return plateName;
	}

	public void setPlateName(String plateName) {
		this.plateName = plateName;
	}

	public int getSeatsbooked() {
		return seatsbooked;
	}

	public void setSeatsbooked(int seatsbooked) {
		this.seatsbooked = seatsbooked;
	}

	public int getTotalSeats() {
		return totalSeats;
	}

	public void setTotalSeats(int totalSeats) {
		this.totalSeats = totalSeats;
	}

	public Date getDailyStartTime() {
		return dailyStartTime;
	}

	public void setDailyStartTime(Date dailyStartTime) {
		this.dailyStartTime = dailyStartTime;
	}

	public Date getDailyStopTime() {
		return dailyStopTime;
	}

	public void setDailyStopTime(Date dailyStopTime) {
		this.dailyStopTime = dailyStopTime;
	}

	public String getBusType() {
		return busType;
	}

	public void setBusType(String busType) {
		this.busType = busType;
	}

	public String getFare() {
		return fare;
	}

	public void setFare(String fare) {
		this.fare = fare;
	}

	public BusRoute getBusRoute() {
		return busRoute;
	}

	public void setBusRoute(BusRoute busRoute) {
		this.busRoute = busRoute;
	}

	@Override
	public String toString() {
		return "Bus [busId=" + busId + ", busName=" + busName + ", plateName=" + plateName + ", seatsbooked="
				+ seatsbooked + ", totalSeats=" + totalSeats + ", dailyStartTime=" + dailyStartTime + ", dailyStopTime="
				+ dailyStopTime + ", busType=" + busType + ", fare=" + fare + ", busRoute=" + busRoute + "]";
	}

}
