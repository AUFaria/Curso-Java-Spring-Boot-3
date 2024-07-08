package br.com.projetospringboot3.jpaadvmaps;

import br.com.projetospringboot3.jpaadvmaps.dao.AppDAO;
import br.com.projetospringboot3.jpaadvmaps.entity.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class JpaadvmapsApplication {

	public static void main(String[] args) {
		SpringApplication.run(JpaadvmapsApplication.class, args);
	}


	@Bean
	public CommandLineRunner commandLineRunner(AppDAO appDAO) {
		return runner -> {
//			createCourseWithStudents(appDAO);
//			getCourseWithStudents(appDAO);
//			getStudentWithCourses(appDAO);
//			addCoursesForStudent(appDAO);
//			deleteCourse(appDAO); // Deleting relationship between Course and Student
			deleteStudent(appDAO);
		};
	}

	private void deleteStudent(AppDAO appDAO) {

		int id = 2;

		System.out.println("Deleting student with id: " + id);

		appDAO.deleteStudentById(id);

		System.out.println("Finished");
	}

	private void addCoursesForStudent(AppDAO appDAO) {

		int id = 2;

		System.out.println("Finding student with id: " + id);
		Student student = appDAO.findStudentWithCourseByStudentId(id);

		Course course1 = new Course("Análise Vetorial");
		Course course2 = new Course("Termodinâmica I");
		Course course3 = new Course("Eletromagnetismo I");
		Course course4 = new Course("Mecânica II");

		student.addCourse(course1);
		student.addCourse(course2);
		student.addCourse(course3);
		student.addCourse(course4);

		System.out.println("Updating student: " + student);
		System.out.println("Courses associated with Student: " + student.getCourses());

		appDAO.update(student);

		System.out.println("Finished");
	}

	private void getStudentWithCourses(AppDAO appDAO) {

		int id = 2;

		System.out.println("Finding student with id: " + id);
		Student student = appDAO.findStudentWithCourseByStudentId(id);

		System.out.println("Student: " + student);
		System.out.println("Courses associated with Student: " + student.getCourses());

		System.out.println("Finished");
	}

	private void getCourseWithStudents(AppDAO appDAO) {

		int id = 10;

		System.out.println("Finding course with id: " + id);
		Course course = appDAO.findCourseWithStudentsByCourseId(id);

		System.out.println("Course: " + course);
		System.out.println("Students associated with Course: " + course.getStudents());

		System.out.println("Finished");
	}

	private void createCourseWithStudents(AppDAO appDAO) {

		Course course = new Course("Geometria Analítica");

		Student student1 = new Student("João", "Silva", "joao.silva@email.com");
		Student student2 = new Student("Pedro", "Henrique", "pedro.henrique@email.com");
		Student student3 = new Student("Maria", "Braga", "maria.braga@email.com");

		course.addStudent(student1);
		course.addStudent(student2);
		course.addStudent(student3);

		System.out.println("Saving course: " + course);
		System.out.println("Students associated with Course: " + course.getStudents());

		appDAO.save(course);

		System.out.println("Finished");
	}

	private void deleteCourseAndReviews(AppDAO appDAO) {

		int id = 10;

		System.out.println("Deleting course with id: " + id);

		appDAO.deleteCourseById(id);

		System.out.println("Finished");
	}

	private void getCourseWithReviews(AppDAO appDAO) {

		int id = 10;

		System.out.println("Finding course with id: " + id);

		Course course = appDAO.findCourseWithReviewsByCourseId(id);

		System.out.println("Course: " + course);
		System.out.println("Reviews associated with Course: " + course.getReviews());

		System.out.println("Finished");
	}

	private void createCourseAndReviews(AppDAO appDAO) {

		Course course = new Course("Matemática Avançada");

		course.addReview(new Review("Curso difícil, não entendi."));
		course.addReview(new Review("Professor não explica direito."));
		course.addReview(new Review("Achei ok..."));
		course.addReview(new Review("Amei! Recomendo."));
		course.addReview(new Review("Perfeito pra quem precisa passar na faculdade!"));

		System.out.println("Saving course: " + course);
		System.out.println("Course reviews: " + course.getReviews());

		appDAO.save(course);

		System.out.println("Finished");
	}

	private void deleteCourse(AppDAO appDAO) {

		int id = 12;

		System.out.println("Deleting course with id: " + id);
		appDAO.deleteCourseById(id);

		System.out.println("Finished");
	}

	private void updateCourse(AppDAO appDAO) {

		int id = 10;

		System.out.println("Finding course with id: " + id);
		Course course = appDAO.findCourseById(id);

		System.out.println("Updating course: " + course);
		course.setTitle("ANOTHERVALUE");

		appDAO.update(course);

		System.out.println("Finished");
	}

	private void updateInstructor(AppDAO appDAO) {

		int id = 1;

		System.out.println("Finding instructor with id: " + id);
		Instructor instructor = appDAO.findInstructorById(id);

		System.out.println("Updating instructor: " + instructor);
		instructor.setLastName("SOMEVALUE");

		appDAO.update(instructor);

		System.out.println("Finished");
	}

	private void findInstructorWithCoursesJoinFetch(AppDAO appDAO) {

		int id = 1;

		System.out.println("Finding instructor (JOIN FETCH method) with id: " + id);
		Instructor instructor = appDAO.findInstructorByIdJoinFetch(id);

		System.out.println("Instructor: " + instructor);
		System.out.println("Courses associated with Instructor: " + instructor.getCourses());

		System.out.println("Finished");
	}

	private void findCoursesForInstructor(AppDAO appDAO) {

		int id = 1;

		System.out.println("Finding instructor with id: " + id);
		Instructor instructor = appDAO.findInstructorById(id);

		System.out.println("Instructor: " + instructor);

		System.out.println("Finding courses for instructor with id: " + id);
		List<Course> courses = appDAO.findCoursesByInstructorId(id);

		instructor.setCourses(courses);

		System.out.println("Courses associated with Instructor: " + instructor.getCourses());

		System.out.println("Finished");
	}

	private void findInstructorWithCourses(AppDAO appDAO) {

		int id = 1;

		System.out.println("Finding instructor with id: " + id);

		Instructor instructor = appDAO.findInstructorById(id);

		System.out.println("Instructor: " + instructor);
		System.out.println("Courses associated with Instructor: " + instructor.getCourses());

		System.out.println("Finished");
	}

	private void createInstructorWithCourses(AppDAO appDAO) {

		Instructor instructor = new Instructor("Paulo", "Barbosa", "paulo.barbosa@email.com");

		InstructorDetail instructorDetail = new InstructorDetail("youtube.com/paulobarbosa", "Futebol");

		instructor.setInstructorDetail(instructorDetail);

		Course course1 = new Course("Física Básica");
		Course course2 = new Course("Química Básica");
		Course course3 = new Course("Física Intermediária");

		instructor.addCourse(course1);
		instructor.addCourse(course2);
		instructor.addCourse(course3);

		System.out.println("Saving instructor: " + instructor);
		System.out.println("Saving courses: " + instructor.getCourses());

		appDAO.save(instructor);

		System.out.println("Finished");
	}

	private void deleteInstructorDetail(AppDAO appDAO) {

		int id = 3;

		System.out.println("Deleting instructor detail with id: " + id);

		appDAO.deleteInstructorDetailById(id);

		System.out.println("Finished");

	}

	private void getInstructorDetail(AppDAO appDAO) {

		int id = 2;

		System.out.println("Finding instructor detail with id: " + id);

		InstructorDetail instructorDetail = appDAO.findInstructorDetailById(id);

		System.out.println("Instructor Detail: " + instructorDetail);
		System.out.println("Instructor associated with Instructor Detail: " + instructorDetail.getInstructor());

	}

	private void deleteInstructor(AppDAO appDAO) {

		int id = 1;

		System.out.println("Deleting instructor with id: " + id);

		appDAO.deleteInstructorById(id);

		System.out.println("Finished");
	}

	private void getInstructor(AppDAO appDAO) {

		int id = 2;

		System.out.println("Finding instructor with id: " + id);

		Instructor instructor = appDAO.findInstructorById(id);

		System.out.println("Instructor: " + instructor);
		System.out.println("Instructor Detail associated with Instructor: " + instructor.getInstructorDetail());
	}

	private void createInstructor(AppDAO appDAO) {

//		Instructor instructor = new Instructor("Joao", "Silva", "joao.silva@email.com");
//
//		InstructorDetail instructorDetail = new InstructorDetail("youtube.com/joao", "Natação");

		Instructor instructor = new Instructor("Pedro", "Henrique", "pedro.henrique@email.com");

		InstructorDetail instructorDetail = new InstructorDetail("youtube.com/pedrohenrique", "Volei");

		instructor.setInstructorDetail(instructorDetail);

		System.out.println("Saving instructor: " + instructor);

		appDAO.save(instructor);

		System.out.println("Finished");
	}
}
