package br.com.projetospringboot3.crudmvc.controller;

import br.com.projetospringboot3.crudmvc.entity.Employee;
import br.com.projetospringboot3.crudmvc.service.EmployeeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

	private final EmployeeService employeeService;

	public EmployeeController(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}

	@GetMapping("/list")
	public String listEmployees(Model model) {

		List<Employee> employeesList = employeeService.findAll();

		model.addAttribute("employees", employeesList);

		return "employees/list-employees";
	}

	@GetMapping("/createForm")
	public String showCreateForm(Model model) {

		Employee employee = new Employee();

		model.addAttribute("employee", employee);

		return "employees/employee-form";
	}

	@GetMapping("/updateForm")
	public String showUpdateForm(
			@RequestParam("employeeId") int id,
			Model model
	) {

		Employee employee = employeeService.findById(id);

		model.addAttribute("employee", employee);

		return "employees/employee-form";
	}

	@PostMapping("/save")
	public String saveEmployee(@ModelAttribute("employee") Employee employee) {

		employeeService.save(employee);

		return "redirect:/employees/list";
	}
}
