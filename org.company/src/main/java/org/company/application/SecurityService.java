package org.company.application;

import java.util.List;

import org.company.domain.Role;
import org.company.domain.User;
import org.company.domain.contracts.IRoleDAO;
import org.company.domain.contracts.IUserDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class SecurityService implements ISecurityService {

	@Autowired
	private IUserDAO userDAO;
	
	@Autowired
	private IRoleDAO roleDAO;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Override
	public void save(User user) {
		String password = user.getPassword();
		
		user.setPassword(passwordEncoder.encode(password));
		
		userDAO.save(user);
	}

	@Override
	public List<Role> findRolesByName(String name) {
		
		return roleDAO.findByName(name);
	}

	


}
