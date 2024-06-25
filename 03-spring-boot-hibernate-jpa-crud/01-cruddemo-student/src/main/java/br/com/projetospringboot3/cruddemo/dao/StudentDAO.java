package br.com.projetospringboot3.cruddemo.dao;

import br.com.projetospringboot3.cruddemo.entity.Student;

public interface StudentDAO {

    void save(Student targetStudent);

    Student findById(Integer id);
}
