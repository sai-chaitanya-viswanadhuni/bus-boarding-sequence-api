package com.boarding.DTO;

public class BusSeatDTO {
	private String seatName;
	private String seatStatus;

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

	@Override
	public String toString() {
		return "BusSeatDTO [seatName=" + seatName + ", seatStatus=" + seatStatus + "]";
	}

}