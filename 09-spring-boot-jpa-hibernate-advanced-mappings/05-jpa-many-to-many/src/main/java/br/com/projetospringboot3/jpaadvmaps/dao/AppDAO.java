package br.com.projetospringboot3.jpaadvmaps.dao;

import br.com.projetospringboot3.jpaadvmaps.entity.Course;
import br.com.projetospringboot3.jpaadvmaps.entity.Instructor;
import br.com.projetospringboot3.jpaadvmaps.entity.InstructorDetail;
import br.com.projetospringboot3.jpaadvmaps.entity.Student;

import java.util.List;

public interface AppDAO {

	void save(Instructor instructor);

	Instructor findInstructorById(int id);

	void deleteInstructorById(int id);

	InstructorDetail findInstructorDetailById(int id);

	void deleteInstructorDetailById(int id);

	List<Course> findCoursesByInstructorId(int id);

	Instructor findInstructorByIdJoinFetch(int id);

	void update(Instructor instructor);

	void update(Course course);

	Course findCourseById(int id);

	void deleteCourseById(int id);

	void save(Course course);

	Course findCourseWithReviewsByCourseId(int id);

	Course findCourseWithStudentsByCourseId(int id);

	Student findStudentWithCourseByStudentId(int id);

	void update(Student student);

	void deleteStudentById(int id);
}
