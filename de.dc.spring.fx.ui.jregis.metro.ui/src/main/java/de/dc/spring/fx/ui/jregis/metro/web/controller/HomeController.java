package de.dc.spring.fx.ui.jregis.metro.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import de.dc.spring.fx.ui.jregis.metro.ui.user.repository.UserRepository;

@Controller
public class HomeController {

	@Autowired UserRepository userRepository;
	
	@GetMapping("/")
	public String greeting(Model model) {
		model.addAttribute("users", userRepository.findAll());
		return "index";
	}
}
