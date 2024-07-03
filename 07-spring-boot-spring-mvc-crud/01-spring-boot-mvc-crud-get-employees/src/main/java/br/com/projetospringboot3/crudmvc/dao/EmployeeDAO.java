package br.com.projetospringboot3.crudmvc.dao;

import br.com.projetospringboot3.crudmvc.entity.Employee;

import java.util.List;

public interface EmployeeDAO {

   List<Employee> findAll();

   Employee findById(int id);

   Employee save(Employee employee);

   void deleteById(int id);
}
