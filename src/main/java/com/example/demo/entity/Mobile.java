package com.example.demo.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
public class Mobile {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	Integer mobile_id;
	
	@Size(max=15)
	@Pattern(regexp = "^[0-9]+$")
	@NotBlank
	String mob1;
	
	@Size(max=15)
	@Pattern(regexp = "^[0-9]+$")
	String mob2;
	
	@Size(max=15)
	@Pattern(regexp = "^[0-9]+$")
	String mob3;
	
	@OneToOne(mappedBy = "mobile")
	Person person;

	public Integer getMobile_id() {
		return mobile_id;
	}

	public void setMobile_id(Integer mobile_id) {
		this.mobile_id = mobile_id;
	}

	public String getMob1() {
		return mob1;
	}

	public void setMob1(String mob1) {
		this.mob1 = mob1;
	}

	public String getMob2() {
		return mob2;
	}

	public void setMob2(String mob2) {
		this.mob2 = mob2;
	}

	public String getMob3() {
		return mob3;
	}

	public void setMob3(String mob3) {
		this.mob3 = mob3;
	}
}
