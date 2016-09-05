package org.company.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BuildingBlocksController {

	@RequestMapping(value = "/building_blocks/index")
	public String index(Model model) {
		model.addAttribute("building_blocks", "active");
		return "building_blocks/index";
	}

	@RequestMapping(value = "/building_blocks/scope_variable")
	public String scope_variable(Model model) {
		model.addAttribute("building_blocks", "active");

		return "building_blocks/scope_variable";
	}

	@RequestMapping(value = "/building_blocks/java_class_structure")
	public String java_class_structure(Model model) {
		model.addAttribute("building_blocks", "active");

		return "building_blocks/java_class_structure";
	}
}
