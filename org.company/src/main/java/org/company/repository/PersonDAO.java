package org.company.repository;



import org.company.domain.Person;
import org.company.domain.contracts.IPersonDAO;
import org.company.repository.base.GenericRepository;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Repository
public class PersonDAO extends GenericRepository<Person> implements IPersonDAO {

}
