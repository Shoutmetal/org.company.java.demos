package org.company.application;

import java.util.List;

import org.company.domain.Role;
import org.company.domain.User;

public interface ISecurityService {
	public void save(User user);
	public List<Role> findRolesByName(String name);
}
