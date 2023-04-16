package com.luv2code.cruddemo.dao;

import java.util.List;

import com.luv2code.cruddemo.entity.Student;

// A DAO is Data Access Object, a Java term for Repo pattern
// A layer between our App and the Database

public interface StudentDAO {
  
  void save(Student theStudent);

  Student findById(Integer id);

  List<Student> findAll();

  List<Student> findByLastName(String theLastName);
  
}
