package org.company.security;

import java.util.ArrayList;
import java.util.List;

import org.company.domain.contracts.IUserDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service("customUserDetailsService")
public class CustomUserDetailsService implements UserDetailsService {

	@Autowired
	private IUserDAO userDAO;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();

		org.company.domain.User domainUser = userDAO.findByUsername(username);

		if (domainUser != null) {
			domainUser.getRoles().forEach(x-> authorities.add(new SimpleGrantedAuthority(x.getName())));
			
			authorities.forEach(x -> System.out.println(x.getAuthority()));
			
			User user = new User(domainUser.getUsername(), domainUser.getPassword(), authorities);
			return user;
		}

		throw new UsernameNotFoundException("the user doesn't not exist");

	}

}
