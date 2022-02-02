package com.example.demo.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Range;

@Entity
public class Person {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	Integer person_id;
	
	@NotBlank(message = "Name is mandatory")
	@NotEmpty
	@Pattern(regexp = "^[A-Za-z][A-Za-z\s]+$")
	@Size(max=25)
	String firstName;
	
	@Pattern(regexp = "^[A-Za-z][A-Za-z\s]+$")
	@Size(max=25)
	String lastName;
	
	@Range(min=0)
	Integer age;
	
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
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "mob_id", referencedColumnName = "mobile_id")
	Mobile mobile;

	public Mobile getMobile() {
		return mobile;
	}

	public void setMobile(Mobile mobile) {
		this.mobile = mobile;
	}

	public Integer getPerson_id() {
		return person_id;
	}

	public void setPerson_id(Integer person_id) {
		this.person_id = person_id;
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

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
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
