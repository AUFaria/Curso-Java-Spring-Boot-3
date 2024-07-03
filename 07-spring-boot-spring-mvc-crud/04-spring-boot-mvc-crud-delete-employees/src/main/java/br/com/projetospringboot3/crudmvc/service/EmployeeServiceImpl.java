package br.com.projetospringboot3.crudmvc.service;


import br.com.projetospringboot3.crudmvc.entity.Employee;
import br.com.projetospringboot3.crudmvc.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService{

   private final EmployeeRepository employeeRepository;

   @Autowired
   public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
      this.employeeRepository = employeeRepository;
   }

   @Override
   public List<Employee> findAll() {
      return employeeRepository.findAllByOrderByLastNameAsc();
   }

   @Override
   public Employee findById(int id) {
      Optional<Employee> result = employeeRepository.findById(id);

      Employee employee = null;

      if(result.isPresent()){
         employee = result.get();
      } else {
         throw new RuntimeException("Employee not found for id: " + id);
      }

      return employee;
   }

   @Override
   @Transactional
   public Employee save(Employee employee) {
      return employeeRepository.save(employee);
   }

   @Override
   @Transactional
   public void deleteById(int id) {
      employeeRepository.deleteById(id);
   }
}
