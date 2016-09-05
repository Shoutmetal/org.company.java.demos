package org.company.application;

import java.util.List;

import org.company.domain.Person;

public interface IPersonService {
	public void save(Person person);
	public List<Person> findAll();
	public Person findById(int Id);
	List<Person> findByName(String name);
	public void delete(Person person);
	public Person update(Person person);
}
