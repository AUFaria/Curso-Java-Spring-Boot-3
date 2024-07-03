package br.com.projetospringboot3.crudmvc.controller;

import br.com.projetospringboot3.crudmvc.entity.Employee;
import br.com.projetospringboot3.crudmvc.service.EmployeeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

	private EmployeeService employeeService;

	public EmployeeController(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}

	@GetMapping("/list")
	public String listEmployees(Model model) {

		List<Employee> employeesList = employeeService.findAll();

		model.addAttribute("employees", employeesList);

		return "list-employees";
	}
}
