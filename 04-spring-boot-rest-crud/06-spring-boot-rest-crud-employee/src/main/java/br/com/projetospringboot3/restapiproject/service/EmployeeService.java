package br.com.projetospringboot3.restapiproject.service;

import br.com.projetospringboot3.restapiproject.entity.Employee;

import java.util.List;

public interface EmployeeService {

   List<Employee> findAll();

   Employee findById(int id);

   Employee save(Employee employee);

   void deleteById(int id);
}
