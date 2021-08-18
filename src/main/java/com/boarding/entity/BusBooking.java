package com.boarding.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;


@Entity
@Table(name = "BUS_BOOKING")
public class BusBooking {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long busBookingId;

	private Long fare;

	private Date dateOfJourney;

	private Date dateOfBooking;

	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "BUS_ID", nullable = false)
	private Bus bus;

	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "USER_ID", nullable = false)
	private User user;

	@OneToMany(mappedBy = "busBooking", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JsonManagedReference
	private List<Ticket> tickets;

	public Long getBusBookingId() {
		return busBookingId;
	}

	public void setBusBookingId(Long busBookingId) {
		this.busBookingId = busBookingId;
	}

	public Long getFare() {
		return fare;
	}

	public void setFare(Long fare) {
		this.fare = fare;
	}

	public Date getDateOfJourney() {
		return dateOfJourney;
	}

	public void setDateOfJourney(Date dateOfJourney) {
		this.dateOfJourney = dateOfJourney;
	}

	public Date getDateOfBooking() {
		return dateOfBooking;
	}

	public void setDateOfBooking(Date dateOfBooking) {
		this.dateOfBooking = dateOfBooking;
	}

	public Bus getBus() {
		return bus;
	}

	public void setBus(Bus bus) {
		this.bus = bus;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<Ticket> getTickets() {
		return tickets;
	}

	public void setTickets(List<Ticket> tickets) {
		this.tickets = tickets;
	}

}
