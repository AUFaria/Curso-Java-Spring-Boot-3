package br.com.projetospringboot3.restapiproject.rest;

import br.com.projetospringboot3.restapiproject.entity.Employee;
import br.com.projetospringboot3.restapiproject.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {

	private final EmployeeService employeeService;

	@Autowired
	public EmployeeRestController(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}

	@GetMapping("/employees")
	public List<Employee> getEmployees() {
		return employeeService.findAll();
	}

	@GetMapping("/employees/{employeeId}")
	public Employee getEmployeeById(@PathVariable int employeeId){

		Employee targetEmployee = employeeService.findById(employeeId);

		if (targetEmployee == null) {
			throw new RuntimeException("Employee not found for id: " + employeeId);
		}

		return targetEmployee;
	}

	@PostMapping("/employees")
	public Employee addEmployee(@RequestBody Employee employee) {

		employee.setId(0);

		Employee targetEmployee = employeeService.save(employee);

		return targetEmployee;
	}

	@PutMapping("/employees")
	public Employee updateEmployee(@RequestBody Employee employee){


		Employee targetEmployee = employeeService.save(employee);

		return targetEmployee;
	}

	@DeleteMapping("/employees/{employeeId}")
	public String deleteEmployee(@PathVariable int employeeId){

		Employee targetEmployee = employeeService.findById(employeeId);

		if (targetEmployee == null) {
			throw new RuntimeException("Employee not found for id: " + employeeId);
		}

		employeeService.deleteById(employeeId);

		return "Employee successfully deleted; id: " + employeeId;
	}
}
