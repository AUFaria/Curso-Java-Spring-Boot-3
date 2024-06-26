package br.com.projetospringboot3.springbootrestcrud.rest;

import br.com.projetospringboot3.springbootrestcrud.entity.Student;
import jakarta.annotation.PostConstruct;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestController {

      private  List<Student> studentsList;

      // REFACTOR: Using @PostConstruct to populate studentsList only once
      @PostConstruct
      public void loadData() {

            studentsList = new ArrayList<>();

            studentsList.add(new Student("AAA", "111"));
            studentsList.add(new Student("BBB", "222"));
            studentsList.add(new Student("CCC", "333"));
      }

      @GetMapping("/students")
      public List<Student> getStudents() {

            return studentsList;
      }

      @GetMapping("/students/{studentId}")
      public Student getStudentById(@PathVariable int studentId) {
            return studentsList.get(studentId);
      }
}
