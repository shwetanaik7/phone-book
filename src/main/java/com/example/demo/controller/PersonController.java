package com.example.demo.controller;


import java.util.Optional;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.demo.PersonRepository;
import com.example.demo.entity.Person;
import com.example.demo.service.PersonService;

@RestController
public class PersonController {
	@Autowired
	PersonService personService;
	
	@Autowired
	PersonRepository personRepository;
	
	@PostMapping("/person")
	@ResponseStatus(code = HttpStatus.CREATED)
	void createContact(@RequestBody @Valid Person person) {
		personService.saveContact(person);
	}
	
	@GetMapping("/display")
	Iterable<Person> getContact() {
		return personService.getContact();
	}
	
	@GetMapping("/display/{id}")
	Optional<Person> getContacts(@PathVariable("id") Integer id) {
		return personService.getContacts(id);
	}
	
	@DeleteMapping("/delete/{id}")
	void deleteContact(@PathVariable("id") Integer id)
	{
		personService.deleteContact(id);
	}
	
	@PutMapping("/edit/{id}")
	public ResponseEntity<Person> updateContact(@PathVariable("id") Integer id, @RequestBody Person person) {
		Person contact = personRepository.findById(id).get();
		if(contact.getFirstName()!=null) {
	        contact.setFirstName(person.getFirstName());
	        contact.setLastName(person.getLastName());
	        contact.setAge(person.getAge());
	        contact.setHouse_no(person.getHouse_no());
	        contact.setCity(person.getCity());
	        contact.setStreet(person.getStreet());
	        contact.setPin(person.getPin());
	        contact.setMobile(person.getMobile());
	      }
	  return new ResponseEntity<Person>(personRepository.save(contact),HttpStatus.OK);
	}
	
}
