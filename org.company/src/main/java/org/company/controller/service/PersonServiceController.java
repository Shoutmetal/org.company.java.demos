package org.company.controller.service;

import java.util.List;

import org.company.application.IPersonService;
import org.company.domain.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
public class PersonServiceController {

	@Autowired
	private IPersonService _service;

	@RequestMapping(value = "/service/person/", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Person>> listAllUsers() {
		List<Person> people = _service.findAll();

		if (people.isEmpty())
			return new ResponseEntity<List<Person>>(HttpStatus.NO_CONTENT); // OR
																			// NOT_FOUND

		return new ResponseEntity<List<Person>>(people, HttpStatus.OK);
	}

	@RequestMapping(value = "/service/person/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Person> findById(@PathVariable("id") int id) {

		Person person = _service.findById(id);
		if (person == null)
			return new ResponseEntity<Person>(HttpStatus.NOT_FOUND);

		return new ResponseEntity<Person>(person, HttpStatus.OK);
	}

	@RequestMapping(value = "/service/person/", method = RequestMethod.POST)
	public ResponseEntity<Void> createUser(@RequestBody Person person, UriComponentsBuilder ucBuilder) {

		_service.save(person);

		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(ucBuilder.path("/service/person/{id}").buildAndExpand(person.getId()).toUri());
		return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}

	@RequestMapping(value = "/service/person/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Person> updateUser(@PathVariable("id") int id, @RequestBody Person person) {

		Person currentPerson = _service.findById(id);

		if (currentPerson == null)
			return new ResponseEntity<Person>(HttpStatus.NOT_FOUND);

		currentPerson.setName(person.getName());
		currentPerson.setAge(person.getAge());
		currentPerson.setStatus(person.getStatus());

		_service.update(currentPerson);
		return new ResponseEntity<Person>(currentPerson, HttpStatus.OK);
	}

	@RequestMapping(value = "/service/person/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Person> deleteUser(@PathVariable("id") int id) {

		Person person = _service.findById(id);
		if (person == null)
			return new ResponseEntity<Person>(HttpStatus.NOT_FOUND);

		_service.delete(person);
		return new ResponseEntity<Person>(HttpStatus.NO_CONTENT);
	}

}
