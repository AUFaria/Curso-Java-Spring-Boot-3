package br.com.projetospringboot3.restapiproject.repository;

import br.com.projetospringboot3.restapiproject.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
}
