package br.com.projetospringboot3.springbootrestcrud.rest;

import br.com.projetospringboot3.springbootrestcrud.entity.Student;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestController {

      @GetMapping("/students")
      public List<Student> getStudents() {
            List<Student> studentsList = new ArrayList<>();

            studentsList.add(new Student("AAA", "111"));
            studentsList.add(new Student("BBB", "222"));
            studentsList.add(new Student("CCC", "333"));

            return studentsList;
      }
}
