package br.com.projetospringboot3.cruddemo;

import br.com.projetospringboot3.cruddemo.dao.StudentDAO;
import br.com.projetospringboot3.cruddemo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO) {
		return runner -> {
//			createStudent(studentDAO);

			createMultipleStudents(studentDAO);
		};
	}

	private void createMultipleStudents(StudentDAO studentDAO) {

		System.out.println("- Creating 3 student objects -");
		Student newStudentOne = new Student("AAA", "aaa", "a@a.a");
		Student newStudentTwo = new Student("BBB", "bbb", "b@b.b");
		Student newStudentThree = new Student("CCC", "ccc", "c@c.c");

		System.out.println("- Saving the 3 students -");
		studentDAO.save(newStudentOne);
		studentDAO.save(newStudentTwo);
		studentDAO.save(newStudentThree);
	}

	private void createStudent(StudentDAO studentDAO) {

		System.out.println("- Creating new student object -");
		Student newStudent = new Student("João", "Silva", "joao.silva@email.com");

		System.out.println("- Saving the student -");
		studentDAO.save(newStudent);

		System.out.println("- Student object saved; id: " + newStudent.getId() + " -");
	}
}
