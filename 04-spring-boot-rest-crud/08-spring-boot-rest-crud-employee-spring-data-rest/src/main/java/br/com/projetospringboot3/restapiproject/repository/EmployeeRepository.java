package br.com.projetospringboot3.restapiproject.repository;

import br.com.projetospringboot3.restapiproject.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

//@RepositoryRestResource(path = "custom-repo-path")
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
}
