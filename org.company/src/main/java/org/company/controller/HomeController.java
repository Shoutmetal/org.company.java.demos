package org.company.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("user")
public class HomeController {

	@RequestMapping("/")
	public String home(Model model) {

		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (auth != null) {
			model.addAttribute("user", auth.getName());
		}

		model.addAttribute("home", "active");
		return "home";
	}

}
