package de.dc.spring.fx.ui.jregis.metro.web.controller;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import de.dc.spring.fx.ui.jregis.metro.ui.document.model.Document;
import de.dc.spring.fx.ui.jregis.metro.ui.document.model.DocumentCategory;
import de.dc.spring.fx.ui.jregis.metro.ui.document.repository.DocumentCategoryRepository;
import de.dc.spring.fx.ui.jregis.metro.ui.document.repository.DocumentRepository;
import de.dc.spring.fx.ui.jregis.metro.ui.gen.activity.repository.ActivityRepository;
import de.dc.spring.fx.ui.jregis.metro.ui.gen.todo.repository.TodoRepository;
import de.dc.spring.fx.ui.jregis.metro.ui.user.repository.UserRepository;

@Controller
public class HomeController {

	@Autowired UserRepository userRepository;
	@Autowired ActivityRepository activityReposity;
	@Autowired TodoRepository todoReposity;
	@Autowired DocumentRepository documentRepository;
	@Autowired DocumentCategoryRepository categoryRepository;
	
	@GetMapping("/")
	public String greeting(Model model) {
		model.addAttribute("todoList", todoReposity.findAll());
		model.addAttribute("recentActivities", activityReposity.findAll());

		model.addAttribute("userCount", userRepository.findAll().size());
		return "index";
	}
	
	@GetMapping("/registrations") 
    public String registrations(Model model) {
		return "registrations";
	}

	@GetMapping("/documentations") 
	public String documentations(Model model) {
		model.addAttribute("document", new Document());
		model.addAttribute("categories", categoryRepository.findAll());
		return "documentations";
	}

	@PostMapping("/data/create/document")
	public String create(@ModelAttribute Document document, @ModelAttribute DocumentCategory category) {
		document.setCreatedOn(LocalDateTime.now());
		document.setUpdatedOn(LocalDateTime.now());
		document.setCategoryId(category.getId());
		documentRepository.save(document);
//		documentUtil.createFolder(document);
		return "redirect:/documentations";
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
