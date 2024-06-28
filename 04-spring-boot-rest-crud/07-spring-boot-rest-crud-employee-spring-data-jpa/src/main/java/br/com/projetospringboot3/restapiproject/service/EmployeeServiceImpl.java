package br.com.projetospringboot3.restapiproject.service;

import br.com.projetospringboot3.restapiproject.entity.Employee;
import br.com.projetospringboot3.restapiproject.repository.EmployeeRepository;
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
      return employeeRepository.findAll();
   }

   @Override
   public Employee findById(int id) {
      Optional<Employee> result = employeeRepository.findById(id);

      Employee targetEmployee = null;

      if (result.isPresent()){
         targetEmployee = result.get();
      } else {
         throw new RuntimeException("Employee not found for id: " + id);
      }

      return targetEmployee;
   }

   @Override
   public Employee save(Employee employee) {
      return employeeRepository.save(employee);
   }

   @Override
   public void deleteById(int id) {
      employeeRepository.deleteById(id);
   }
}
