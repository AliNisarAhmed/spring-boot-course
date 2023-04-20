package com.ali.restdemo.rest;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ali.restdemo.entity.Student;

@RestController
@RequestMapping("/api")
public class StudentRestController {

  @GetMapping("/students")
  public List<Student> getStudents() {
    List<Student> theStudents = new ArrayList<>();
    theStudents.add(new Student("Ali", "Ahmed"));
    theStudents.add(new Student("Samrah", "Akber"));
    theStudents.add(new Student("Azlan", "Ali"));
    return theStudents;
  }

}
