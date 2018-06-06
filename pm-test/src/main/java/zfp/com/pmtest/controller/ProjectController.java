package zfp.com.pmtest.controller;



import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import zfp.com.pmtest.dao.ProjectRepository;
import zfp.com.pmtest.entity.Project;

@Controller()
public class ProjectController {
	
	@Autowired
	ProjectRepository projectRepository;
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());

		
	@GetMapping("/projects")
	public String getProjects( Model model) {
		
		model.addAttribute("projects", projectRepository.findAll());
		
		return "project";
	}
	
	
	
	

}
