package com.boarding.DTO;

public class TicketsDTO {

	private BusSeatDTO busSeat;
	private PassengersDTO passenger;
	private Long ticketFare;

	public BusSeatDTO getBusSeat() {
		return busSeat;
	}

	public void setBusSeat(BusSeatDTO busSeat) {
		this.busSeat = busSeat;
	}

	public PassengersDTO getPassenger() {
		return passenger;
	}

	public void setPassenger(PassengersDTO passenger) {
		this.passenger = passenger;
	}

	public Long getTicketFare() {
		return ticketFare;
	}

	public void setTicketFare(Long ticketFare) {
		this.ticketFare = ticketFare;
	}

	@Override
	public String toString() {
		return "TicketsDTO [busSeat=" + busSeat + ", passenger=" + passenger + ", ticketFare=" + ticketFare + "]";
	}

}