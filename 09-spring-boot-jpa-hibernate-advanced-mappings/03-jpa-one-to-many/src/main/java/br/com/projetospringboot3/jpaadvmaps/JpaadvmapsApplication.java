package br.com.projetospringboot3.jpaadvmaps;

import br.com.projetospringboot3.jpaadvmaps.dao.AppDAO;
import br.com.projetospringboot3.jpaadvmaps.entity.Course;
import br.com.projetospringboot3.jpaadvmaps.entity.Instructor;
import br.com.projetospringboot3.jpaadvmaps.entity.InstructorDetail;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class JpaadvmapsApplication {

	public static void main(String[] args) {
		SpringApplication.run(JpaadvmapsApplication.class, args);
	}


	@Bean
	public CommandLineRunner commandLineRunner(AppDAO appDAO) {
		return runner -> {
//			createInstructor(appDAO);
//		  getInstructor(appDAO);
//		  deleteInstructor(appDAO);
//		  getInstructorDetail(appDAO);
//		  deleteInstructorDetail(appDAO);
			createInstructorWithCourses(appDAO);
		};
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
