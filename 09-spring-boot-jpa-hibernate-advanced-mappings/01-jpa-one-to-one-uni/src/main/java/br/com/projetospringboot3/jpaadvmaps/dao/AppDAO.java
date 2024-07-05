package br.com.projetospringboot3.jpaadvmaps.dao;

import br.com.projetospringboot3.jpaadvmaps.entity.Instructor;

public interface AppDAO {

	void save(Instructor instructor);

	Instructor findInstructorById(int id);

	void deleteInstructorById(int id);
}
