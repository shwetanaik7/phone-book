package com.example.demo.controller;


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
	
	@DeleteMapping("/delete/{id}")
	void deleteContact(@PathVariable("id") Integer id)
	{
		personService.deleteContact(id);
	}
	
	@PutMapping("/edit/{id}")
	public ResponseEntity<Person> updateContact(@PathVariable("id") Integer id, @RequestBody Person person) {
		Person contact = personRepository.findById(id).get();
		if(contact.getfName()!=null) {
	        contact.setfName(person.getfName());
	        contact.setlName(person.getlName());
	        contact.setAge(person.getAge());
	        contact.setAddress(person.getAddress());
	        contact.setMobile(person.getMobile());
	      }
	  return new ResponseEntity<Person>(personRepository.save(contact),HttpStatus.OK);
	}
	
}
