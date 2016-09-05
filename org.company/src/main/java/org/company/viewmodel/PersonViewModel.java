package org.company.viewmodel;

import javax.validation.Valid;

import org.company.domain.Address;
import org.company.domain.Person;
import org.springframework.beans.factory.annotation.Autowired;

public class PersonViewModel {
	
	@Autowired
	@Valid
	private Person person;
	
	@Autowired
	private Address address;
	
	public Person getPerson() {
		return person;
	}
	public void setPerson(Person person) {
		this.person = person;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	
	
}
