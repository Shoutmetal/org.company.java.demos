package org.company.application;

import java.util.List;

import org.company.domain.Person;
import org.company.domain.contracts.IPersonDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class PersonService implements IPersonService{
	
	@Autowired
	private IPersonDAO personDAO;
		
	@Override
	public void save(Person person)
	{
		personDAO.save(person);
	}
	
	@Override
	public List<Person> findAll()
	{
		return personDAO.findAll();
	}
	
	@Override
	public Person findById(int Id)
	{
		return personDAO.findById(Id);
	}
	
	public List<Person> findByName(String name)
	{
		return personDAO.findByName(name);
	}

	@Override
	public void delete(Person person) {
		personDAO.delete(person);
		
	}

	@Override
	public Person update(Person person) {

		return personDAO.update(person);
	}
}
