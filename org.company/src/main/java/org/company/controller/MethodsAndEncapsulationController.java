package org.company.controller;

import java.io.IOException;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MethodsAndEncapsulationController {

	@RequestMapping(value="/methods_and_encapsulation/index")
	public String index(Model model) throws IOException{
		model.addAttribute("methods_and_encapsulation", "active");
		return "methods_and_encapsulation/index";
	}
}
