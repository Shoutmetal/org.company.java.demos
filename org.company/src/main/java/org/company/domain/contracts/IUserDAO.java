package org.company.domain.contracts;

import org.company.domain.User;
import org.company.domain.base.IGenericRepository;

public interface IUserDAO extends IGenericRepository<User> {
	public User findByUsername(String username);
	
}
