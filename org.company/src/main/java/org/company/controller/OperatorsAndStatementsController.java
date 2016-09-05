package org.company.controller;

import java.io.IOException;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class OperatorsAndStatementsController {
	@RequestMapping(value="/operators_and_statements/index")
	public String index(Model model) throws IOException{
		model.addAttribute("operators_and_statements", "active");
		return "operators_and_statements/index";
	}
}
