package br.com.projetospringboot3.restapiproject.dao;

import br.com.projetospringboot3.restapiproject.entity.Employee;

import java.util.List;

public interface EmployeeDAO {

   List<Employee> findAll();

   Employee findById(int id);

   Employee save(Employee employee);

   void deleteById(int id);
}
