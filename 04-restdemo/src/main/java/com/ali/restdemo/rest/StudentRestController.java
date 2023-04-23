package com.ali.restdemo.rest;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ali.restdemo.entity.Student;

import jakarta.annotation.PostConstruct;

@RestController
@RequestMapping("/api")
public class StudentRestController {

  private List<Student> theStudents;

  @PostConstruct
  // called after the constructor when the dependencies are fully initialized
  // ensures that this method will be invoked only ONCE in the bean lifecycle
  public void LoadData() {
    theStudents = new ArrayList<Student>();
    theStudents.add(new Student("Ali", "Ahmed"));
    theStudents.add(new Student("Samrah", "Akber"));
    theStudents.add(new Student("Azlan", "Ali"));

  }

  @GetMapping("/students")
  public List<Student> getStudents() {
    return theStudents;
  }

  @GetMapping("/students/{studentId}")
  public Student getStudent(@PathVariable int studentId) {
    if (studentId >= theStudents.size() || studentId < 0) {
      throw new StudentNotFoundException("Student id not found: " + studentId);
    }
    return theStudents.get(studentId);
  }

}
