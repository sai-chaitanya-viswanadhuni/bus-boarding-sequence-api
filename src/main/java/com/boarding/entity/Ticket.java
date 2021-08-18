package com.boarding.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class Ticket {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long ticketId;

	private Long ticketFare;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "PASSENGER_ID")
	private Passenger passenger;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "BUS_BOOKING_ID")
	@JsonBackReference
	private BusBooking busBooking;

	@OneToOne
	@JoinColumn(name = "BUS_SEAT_ID")
	private BusSeat busSeat;

	public Long getTicketId() {
		return ticketId;
	}

	public void setTicketId(Long ticketId) {
		this.ticketId = ticketId;
	}

	public Long getTicketFare() {
		return ticketFare;
	}

	public void setTicketFare(Long ticketFare) {
		this.ticketFare = ticketFare;
	}

	public Passenger getPassenger() {
		return passenger;
	}

	public void setPassenger(Passenger passenger) {
		this.passenger = passenger;
	}

	public BusBooking getBusBooking() {
		return busBooking;
	}

	public void setBusBooking(BusBooking busBooking) {
		this.busBooking = busBooking;
	}

	public BusSeat getBusSeat() {
		return busSeat;
	}

	public void setBusSeat(BusSeat busSeat) {
		this.busSeat = busSeat;
	}

	@Override
	public String toString() {
		return "Ticket [ticketId=" + ticketId + ", ticketFare=" + ticketFare + ", passenger=" + passenger
				+ ", busBooking=" + busBooking + ", busSeat=" + busSeat + "]";
	}

}
