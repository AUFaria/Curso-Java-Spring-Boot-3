package br.com.projetospringboot3.springbootrestcrud.rest;

import br.com.projetospringboot3.springbootrestcrud.entity.Student;
import jakarta.annotation.PostConstruct;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestController {

      private  List<Student> studentsList;

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

            if ( (studentId >= studentsList.size()) || (studentId < 0)) {
                  throw new StudentNotFoundException("Student not found for id: " + studentId);
            }

            return studentsList.get(studentId);
      }
}
