package zfp.com.pmtest.controller;



import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import zfp.com.pmtest.commands.EmployeeCommand;
import zfp.com.pmtest.dao.EmployeeRepository;
import zfp.com.pmtest.entity.Employee;
import zfp.com.pmtest.services.EmployeeService;

@Controller()
public class EmployeeController {
	
	private final EmployeeService employeeService;

     public EmployeeController(EmployeeService employeeService) {
		super();
		this.employeeService = employeeService;
	}
     
     @RequestMapping("/employee/")
     public String getEmployees(Model model){

    	 model.addAttribute("employees", employeeService.getEmployees());

         return "employee";
     }

	@RequestMapping("/employee/{id}/show")
    public String showById(@PathVariable String id, Model model){

        model.addAttribute("employee", employeeService.findById(new Integer(id)));

        return "employeePopUp";
    }

    @RequestMapping("/new")
    public String newEmployee(Model model){
        model.addAttribute("employee", new EmployeeCommand());

        return "/employeeform";
    }

    @RequestMapping("employee/{id}/update")
    public String updateEmployee(@PathVariable String id, Model model){
        model.addAttribute("employee", employeeService.findCommandById(Integer.valueOf(id)));
        return  "/employeeform";
    }

    @PostMapping("employee")
    public String saveOrUpdate(@ModelAttribute EmployeeCommand command){
    	EmployeeCommand savedCommand = employeeService.saveEmployeeCommand(command);

        return "redirect:/employee/" + savedCommand.getId() + "/show";
    }
}

