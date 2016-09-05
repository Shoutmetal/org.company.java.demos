package org.company.controller;

import java.io.IOException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CoreJavaAPIController {
	
	@RequestMapping(value="/core_java_api/index")
	public String index(Model model) throws IOException{

		model.addAttribute("core_java_api", "active");
		return "core_java_api/index";
	}
}
