package br.com.projetospringboot3.crudmvc.dao;

import br.com.projetospringboot3.crudmvc.entity.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeDAOJpaImpl implements EmployeeDAO{

   private final EntityManager entityManager;

   @Autowired
   public EmployeeDAOJpaImpl(EntityManager entityManager) {
      this.entityManager = entityManager;
   }

   @Override
   public List<Employee> findAll() {

      TypedQuery<Employee> query = entityManager.createQuery("FROM Employee", Employee.class);

      List<Employee> employeesList = query.getResultList();

      return employeesList;
   }

   @Override
   public Employee findById(int id) {

      Employee employee = entityManager.find(Employee.class, id);

      return employee;
   }

   @Override
   public Employee save(Employee employee) {

      Employee targetEmployee = entityManager.merge(employee);

      return targetEmployee;
   }

   @Override
   public void deleteById(int id) {

      Employee targetEmployee = entityManager.find(Employee.class, id);

      entityManager.remove(targetEmployee);
   }
}
