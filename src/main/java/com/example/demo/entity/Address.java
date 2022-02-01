package com.example.demo.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
public class Address {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	Integer address_id;
	
	@Pattern(regexp = "^[1-9][0-9\s]+$")
	String house_no;
	
	@NotNull
	@Size(max=25)
	@NotBlank(message = "Street is mandatory")
	@NotEmpty
	@Pattern(regexp = "^[A-Za-z][A-Za-z\s]+$")
	String street;
	
	@NotNull
	@Size(max=25)
	@NotBlank(message = "City is mandatory")
	@NotEmpty
	@Pattern(regexp = "^[A-Za-z][A-Za-z\s]+$")
	String city;
	
	@NotNull
	@Size(max=7)
	@NotBlank(message = "pin is mandatory")
	@NotEmpty
	@Pattern(regexp = "^[1-9][0-9\s]+$")
	String pin;
	
	@OneToOne(mappedBy = "address")
	Person person;

	public Integer getAddress_id() {
		return address_id;
	}

	public void setAddress_id(Integer address_id) {
		this.address_id = address_id;
	}

	public String getHouse_no() {
		return house_no;
	}

	public void setHouse_no(String house_no) {
		this.house_no = house_no;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getPin() {
		return pin;
	}

	public void setPin(String pin) {
		this.pin = pin;
	}
	
}
