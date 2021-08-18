package com.boarding.DTO;

import java.util.Date;
import java.util.List;

public class BusBookingDTO {

	private Long userID;

	private Long busID;

	private Date dateOfBooking;

	private Date dateOfJourney;

	private Long fare;

	private List<TicketsDTO> ticketDetails;

	public Long getUserID() {
		return userID;
	}

	public void setUserID(Long userID) {
		this.userID = userID;
	}

	public Long getBusID() {
		return busID;
	}

	public void setBusID(Long busID) {
		this.busID = busID;
	}

	public Date getDateOfBooking() {
		return dateOfBooking;
	}

	public void setDateOfBooking(Date dateOfBooking) {
		this.dateOfBooking = dateOfBooking;
	}

	public Date getDateOfJourney() {
		return dateOfJourney;
	}

	public void setDateOfJourney(Date dateOfJourney) {
		this.dateOfJourney = dateOfJourney;
	}

	public Long getFare() {
		return fare;
	}

	public void setFare(Long fare) {
		this.fare = fare;
	}

	public List<TicketsDTO> getTicketDetails() {
		return ticketDetails;
	}

	public void setTicketDetails(List<TicketsDTO> ticketDetails) {
		this.ticketDetails = ticketDetails;
	}

	@Override
	public String toString() {
		return "BusBookingDTO [userID=" + userID + ", busID=" + busID + ", dateOfBooking=" + dateOfBooking
				+ ", dateOfJourney=" + dateOfJourney + ", fare=" + fare + ", ticketDetails=" + ticketDetails + "]";
	}

}
