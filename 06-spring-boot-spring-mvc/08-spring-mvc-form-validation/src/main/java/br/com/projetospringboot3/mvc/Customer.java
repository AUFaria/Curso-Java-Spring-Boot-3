package br.com.projetospringboot3.mvc;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class Customer {

	private String firstName;

	@NotNull(message = "Required field")
	@Size(min = 3, message = "Length must be higher than 3")
	private String lastName;



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
}
