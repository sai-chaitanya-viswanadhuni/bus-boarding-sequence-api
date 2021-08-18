package com.boarding.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class BusSeat {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long seatId;

	@Column(name = "SEAT_NAME")
	private String seatName;

	@Column(name = "SEAT_STATUS")
	private String seatStatus;

	@ManyToOne
	@JoinColumn(name = "BUS_ID")
	private Bus bus;

	public Long getSeatId() {
		return seatId;
	}

	public void setSeatId(Long seatId) {
		this.seatId = seatId;
	}

	public String getSeatName() {
		return seatName;
	}

	public void setSeatName(String seatName) {
		this.seatName = seatName;
	}

	public String getSeatStatus() {
		return seatStatus;
	}

	public void setSeatStatus(String seatStatus) {
		this.seatStatus = seatStatus;
	}

	public Bus getBus() {
		return bus;
	}

	public void setBus(Bus bus) {
		this.bus = bus;
	}

	@Override
	public String toString() {
		return "BusSeat [seatId=" + seatId + ", seatName=" + seatName + ", seatStatus=" + seatStatus + ", bus=" + bus
				+ "]";
	}

}
