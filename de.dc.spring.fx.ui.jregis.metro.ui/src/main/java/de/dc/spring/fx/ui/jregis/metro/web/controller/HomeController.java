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
	
	@GetMapping("/registrations") 
    public String registrations(Model model) {
		return "registrations";
	}

	@GetMapping("/documentations") 
	public String documentations(Model model) {
//		model.addAttribute("document", new Document());
//		model.addAttribute("categories", categoryService.findAll());
		return "documentations";
	}

	@GetMapping("/jira_tickets") 
	public String jiraTickets(Model model) {
//		model.addAttribute("ticket", new JiraTicket());
//		model.addAttribute("statusList", statusService.findAll());
//		model.addAttribute("typeList", typeService.findAll());
//		model.addAttribute("projectList", projectService.findAll());
		return "jira_tickets";
	}

	@GetMapping("/jira_projects") 
	public String jiraProjects(Model model) {
//		model.addAttribute("project", new JiraProject());
//		model.addAttribute("projectList", projectService.findAll());
		return "jira_projects";
	}

	@GetMapping("/users") 
	public String users(Model model) {
		model.addAttribute("users", userRepository.findAll());
//		model.addAttribute("projectList", projectService.findAll());
		return "users";
	}
}
