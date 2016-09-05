package org.company.controller;

import java.io.IOException;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ExceptionsController {

	@RequestMapping(value="/exceptions/index")
	public String index(Model model) throws IOException{
		model.addAttribute("exceptions", "active");
		return "exceptions/index";
	}
}
