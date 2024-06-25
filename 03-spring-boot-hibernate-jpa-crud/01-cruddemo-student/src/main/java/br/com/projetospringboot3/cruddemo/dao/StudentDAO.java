package br.com.projetospringboot3.cruddemo.dao;

import br.com.projetospringboot3.cruddemo.entity.Student;

import java.util.List;

public interface StudentDAO {

    void save(Student targetStudent);

    Student findById(Integer id);

    List<Student> findAll();

    List<Student> findByLastName(String targetLastName);

    void  update(Student targetStudent);
}
