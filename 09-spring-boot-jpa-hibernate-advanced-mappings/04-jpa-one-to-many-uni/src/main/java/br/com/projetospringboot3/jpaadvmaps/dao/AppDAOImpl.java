package br.com.projetospringboot3.jpaadvmaps.dao;

import br.com.projetospringboot3.jpaadvmaps.entity.Course;
import br.com.projetospringboot3.jpaadvmaps.entity.Instructor;
import br.com.projetospringboot3.jpaadvmaps.entity.InstructorDetail;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class AppDAOImpl implements AppDAO {

	private final EntityManager entityManager;

	@Autowired
	public AppDAOImpl(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Override
	@Transactional
	public void save(Instructor instructor) {
		entityManager.persist(instructor);
	}

	@Override
	public Instructor findInstructorById(int id) {
		return entityManager.find(Instructor.class, id);
	}

	@Override
	@Transactional
	public void deleteInstructorById(int id) {
		Instructor instructor = entityManager.find(Instructor.class, id);

		List<Course> courses = instructor.getCourses();

		for (Course course : courses) {
			course.setInstructor(null);
		}

		entityManager.remove(instructor);
	}

	@Override
	public InstructorDetail findInstructorDetailById(int id) {
		return entityManager.find(InstructorDetail.class, id);
	}

	@Override
	@Transactional
	public void deleteInstructorDetailById(int id) {
		InstructorDetail instructorDetail = entityManager.find(InstructorDetail.class, id);

		instructorDetail.getInstructor().setInstructorDetail(null);

		entityManager.remove(instructorDetail);
	}

	@Override
	public List<Course> findCoursesByInstructorId(int id) {

		TypedQuery<Course> query = entityManager.createQuery("FROM Course WHERE instructor.id = :data", Course.class);
		query.setParameter("data", id);

		List<Course> courses = query.getResultList();

		return courses;
	}

	@Override
	public Instructor findInstructorByIdJoinFetch(int id) {

		TypedQuery<Instructor> query = entityManager.createQuery(
					"SELECT i FROM Instructor i " +
					"JOIN FETCH i.courses " +
					"JOIN FETCH i.instructorDetail " +
					"WHERE i.id = :data",
					Instructor.class
		);

		query.setParameter("data", id);

		Instructor instructor = query.getSingleResult();

		return instructor;
	}

	@Override
	@Transactional
	public void update(Instructor instructor) {
		entityManager.merge(instructor);
	}

	@Override
	@Transactional
	public void update(Course course) {
		entityManager.merge(course);
	}

	@Override
	public Course findCourseById(int id) {
		return entityManager.find(Course.class, id);
	}

	@Override
	@Transactional
	public void deleteCourseById(int id) {
		Course course = entityManager.find(Course.class, id);

		entityManager.remove(course);
	}

	@Override
	@Transactional
	public void save(Course course) {
		entityManager.persist(course);
	}

	@Override
	public Course findCourseWithReviewsByCourseId(int id) {

		TypedQuery<Course> query = entityManager.createQuery(
					"SELECT c FROM Course c " +
					"JOIN FETCH c.reviews " +
					"WHERE c.id = :data",
					Course.class
		);

		query.setParameter("data", id);

		Course course = query.getSingleResult();

		return course;
	}
}
