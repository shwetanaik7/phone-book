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
	String fName;
	
	@Pattern(regexp = "^[A-Za-z][A-Za-z\s]+$")
	@Size(max=25)
	String lName;
	
	@Range(min=0)
	Integer age;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "add_id", referencedColumnName = "address_id")
	Address address;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "mob_id", referencedColumnName = "mobile_id")
	Mobile mobile;

	public Mobile getMobile() {
		return mobile;
	}

	public void setMobile(Mobile mobile) {
		this.mobile = mobile;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public Integer getPerson_id() {
		return person_id;
	}

	public void setPerson_id(Integer person_id) {
		this.person_id = person_id;
	}

	public String getfName() {
		return fName;
	}

	public void setfName(String fName) {
		this.fName = fName;
	}

	public String getlName() {
		return lName;
	}

	public void setlName(String lName) {
		this.lName = lName;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}
	

}
