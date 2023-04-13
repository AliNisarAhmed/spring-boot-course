package com.luv2code.cruddemo.dao;

import com.luv2code.cruddemo.entity.Student;

// A DAO is Data Access Object, a Java term for Repo pattern
// A layer between our App and the Database

public interface StudentDAO {
  
  void save(Student theStudent);
  
}
