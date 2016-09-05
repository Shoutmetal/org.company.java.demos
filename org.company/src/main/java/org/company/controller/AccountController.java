package org.company.controller;

import java.util.HashSet;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.company.application.ISecurityService;
import org.company.domain.Role;
import org.company.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class AccountController {

	private static String ROLE_GUESS = "ROLE_GUESS";
	
	@Autowired
	private User user;

	
	@Autowired
	private ISecurityService service;
	
	@RequestMapping(value = "/account/login")
	public String login(
			@RequestParam(value = "error", required = false) String error,
			Model model) {
		
		if (error != null) 
			model.addAttribute("error", "Invalid username and password!");
		
		
		return "account/login";
	}
	
	@RequestMapping(value = "/account/logout")
	public String logout(HttpServletRequest request, HttpServletResponse response) {
		
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (auth != null)
			new SecurityContextLogoutHandler().logout(request, response, auth);
		
		return "redirect:/account/login";
	}
	
	@RequestMapping(value = "/account/createUser",method=RequestMethod.GET)
	public String createUser(Model model) {
		
		model.addAttribute("User", user);
		
		return "account/createUser";
	}
	
	@RequestMapping(value = "/account/saveUser",method=RequestMethod.POST)
	public String saveUser(@ModelAttribute("User") User user) {
		
		Set<Role> roles = new HashSet<Role>(service.findRolesByName(ROLE_GUESS));
		user.setRoles(roles);
		service.save(user);
		
		return "redirect:/account/login";
	}
}
