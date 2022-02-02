package com.example.demo.service;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.PersonRepository;
import com.example.demo.entity.Person;

@Service
public class PersonService {
	@Autowired
	PersonRepository personRepository;

	public void saveContact(@Valid Person person) {
		personRepository.save(person);
	}

	public Iterable<Person> getContact() {
		return personRepository.findAll();
	}

	public void deleteContact(Integer id) {
		personRepository.deleteById(id);
	}

	public Optional<Person> getContacts(Integer id) {
		return personRepository.findById(id);
	}

}
