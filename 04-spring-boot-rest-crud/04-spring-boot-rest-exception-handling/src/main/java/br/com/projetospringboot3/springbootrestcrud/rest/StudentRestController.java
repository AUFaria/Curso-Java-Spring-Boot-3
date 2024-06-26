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

      @ExceptionHandler
      public ResponseEntity<StudentErrorResponse>  handleException(StudentNotFoundException exception) {

            StudentErrorResponse error = new StudentErrorResponse();

            error.setStatus(HttpStatus.NOT_FOUND.value());
            error.setMessage(exception.getMessage());
            error.setTimeStamp(System.currentTimeMillis());

            return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
      }

      @ExceptionHandler
      public  ResponseEntity<StudentErrorResponse> handleException(Exception exception) {

            StudentErrorResponse error = new StudentErrorResponse();

            error.setStatus(HttpStatus.BAD_REQUEST.value());
            error.setMessage(exception.getMessage()); // Default message from Exception
//            error.setMessage("There was an error processing your request."); // Custom message
            error.setTimeStamp(System.currentTimeMillis());

            return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
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
