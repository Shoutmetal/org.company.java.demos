package org.company.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.company.application.IAddressService;
import org.company.application.IPersonService;
import org.company.domain.Address;
import org.company.domain.Person;
import org.company.viewmodel.PersonViewModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ExampleController {

	@Autowired
	private Person person;

	@Autowired
	private Address address;

	@Autowired
	private IPersonService personService;

	@Autowired
	private IAddressService addressService;

	@RequestMapping(value = "/example/index")
	public String index(Model model) {

		model.addAttribute("PersonViewModel", new PersonViewModel());
		model.addAttribute("people", personService.findAll());

		return "example/index";
	}

	@RequestMapping(value = "/example/save", method = RequestMethod.POST)
	public String save(@ModelAttribute("PersonViewModel") @Valid PersonViewModel viewmodel, BindingResult result,
			Model model) {

		result.getAllErrors().forEach(x -> System.out.println(x));

		if (result.hasErrors()) {
			model.addAttribute("people", personService.findAll());
			return "example/index";
		}

		person = viewmodel.getPerson();
		personService.save(person);

		return "redirect:/example/index";
	}
	
	
	@RequestMapping(value = "/example/delete/{id}", method = RequestMethod.GET)
	public String delete(@ModelAttribute("id") int Id, Model model) {
			
		personService.delete(personService.findById(Id));

		return "redirect:/example/index";
	}
	

	@RequestMapping(value = "/example/address/{id}", method = RequestMethod.GET)
	public String address(@ModelAttribute("id") int Id, Model model) {

		address.setPerson(personService.findById(Id));
		model.addAttribute("Address", address);

		return "example/address";

	}

	@RequestMapping(value = "/example/addressSave", method = RequestMethod.POST)
	public String addressSave(@ModelAttribute("Address") Address address, Model model) {

		addressService.save(address);

		return "redirect:/example/index";
	}

	@RequestMapping(value = "/example/search", produces = "application/json")
	@ResponseBody
	public Map<String, Object> findAll(@RequestParam("term") String term) {

		Map<String, Object> map = new HashMap<String, Object>();
		List<Person> people = personService.findByName(term);

		people.forEach(x -> map.put(x.getId() + "", x.getName()));
		return map;
	}

	@RequestMapping(value = "/example/ajaxMethod", produces = "application/json")
	@ResponseBody
	public List<Person> ajaxMethod(String data) {
		List<Person> people = personService.findAll();

		return people;
	}

	@RequestMapping(value = "/example/partialMethod", produces = "text/html")
	@ResponseBody
	public String partialMethod() {

		return "example/partialView";
	}
}
