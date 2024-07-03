package br.com.projetospringboot3.crudmvc.service;

import br.com.projetospringboot3.crudmvc.entity.Employee;

import java.util.List;

public interface EmployeeService {

   List<Employee> findAll();

   Employee findById(int id);

   Employee save(Employee employee);

   void deleteById(int id);
}
