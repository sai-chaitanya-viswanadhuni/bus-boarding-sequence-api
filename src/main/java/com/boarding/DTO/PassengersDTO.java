package com.boarding.DTO;

public class PassengersDTO {

	private String passengerName;
	private String passengerAge;

	public String getPassengerName() {
		return passengerName;
	}

	public void setPassengerName(String passengerName) {
		this.passengerName = passengerName;
	}

	public String getPassengerAge() {
		return passengerAge;
	}

	public void setPassengerAge(String passengerAge) {
		this.passengerAge = passengerAge;
	}

	@Override
	public String toString() {
		return "PassengersDTO [passengerName=" + passengerName + ", passengerAge=" + passengerAge + "]";
	}

}
