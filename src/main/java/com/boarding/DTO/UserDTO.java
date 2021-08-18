package com.boarding.DTO;

import org.springframework.lang.NonNull;

public class UserDTO {

	@NonNull
	private String email;

	@NonNull
	private String password;

	private String firstName;

	private String lastName;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	@Override
	public String toString() {
		return "UserDTO [email=" + email + ", password=" + password + ", firstName=" + firstName + ", lastName="
				+ lastName + "]";
	}

}
