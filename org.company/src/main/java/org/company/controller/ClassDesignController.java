package org.company.controller;

import java.io.IOException;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;



@Controller
public class ClassDesignController {

	@RequestMapping(value="/class_design/index")
	public String index(Model model) throws IOException{
		
		model.addAttribute("class_design", "active");
		return "class_design/index";
	}
}
