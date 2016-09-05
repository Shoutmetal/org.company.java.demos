package org.company.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class CustomAuthenticationProvider implements AuthenticationProvider {

	@Autowired
	private CustomUserDetailsService customUserDetailsService;
	
	@Autowired
	private PasswordEncoder passwordEncoder;

	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {

		String principal = authentication.getName();
		String credentials = (String) authentication.getCredentials();

		User user = (User) customUserDetailsService.loadUserByUsername(principal);
		
		if (user != null && passwordEncoder.matches(credentials, user.getPassword()))
			return new UsernamePasswordAuthenticationToken(principal, user.getPassword(), user.getAuthorities());
		
		
		throw new BadCredentialsException("username or password incorrect");
	}

	@Override
	public boolean supports(Class<?> authentication) {
		return true; // (UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication));
	}

}
