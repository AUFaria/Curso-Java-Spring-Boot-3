package br.com.projetospringboot3.mvc;

import jakarta.validation.constraints.*;

public class Customer {

	private String firstName;

	@NotNull(message = "Required field")
	@Size(min = 3, message = "Length must be higher than 3")
	private String lastName;

	@Min(value = 0, message = "Must be greater than or equal to 0")
	@Max(value = 10, message = "Must be less than or equal to 10")
	private int freePasses;

	@Pattern(regexp = "^[a-zA-Z0-9]{5}", message = "Only 5 characters/digits")
	private String postalCode;


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

	public int getFreePasses() {
		return freePasses;
	}

	public void setFreePasses(int freePasses) {
		this.freePasses = freePasses;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}
}
