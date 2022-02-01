package com.example.demo.controller;


import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Person;
import com.example.demo.service.PersonService;

@RestController
public class PersonController {
	@Autowired
	PersonService personService;
	
	@PostMapping("/person")
	@ResponseStatus(code = HttpStatus.CREATED)
	void createContact(@RequestBody @Valid Person person) {
		personService.saveContact(person);
	}
	
	@GetMapping("/display")
	Iterable<Person> getContact() {
		return personService.getContact();
	}
	
	@DeleteMapping("/delete/{id}")
	void deleteContact(@PathVariable("id") Integer id)
	{
		personService.deleteContact(id);
	}
}
