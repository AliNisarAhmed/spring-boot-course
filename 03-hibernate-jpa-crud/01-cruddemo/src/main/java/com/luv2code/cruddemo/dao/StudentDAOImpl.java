package com.luv2code.cruddemo.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.luv2code.cruddemo.entity.Student;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Repository
// @Repository translates JDBC exceptions, its a specialized annotation for
// Repositories
public class StudentDAOImpl implements StudentDAO {

  private EntityManager entityManager;

  @Autowired
  public StudentDAOImpl(EntityManager entityManager) {
    this.entityManager = entityManager;
  }

  @Override
  @Transactional // use Transaction since we are performing an update
  public void save(Student theStudent) {
    entityManager.persist(theStudent);
  }

  @Override
  public Student findById(Integer id) {
    return entityManager.find(Student.class, id);
  }

  @Override
  public List<Student> findAll() {
    // create query
    // NOTE: "Student" inside the query string refers to the name of the Entity
    // rather than the DB Table
    // "lastName" refers to the Entity field, not DB table
    TypedQuery<Student> theQuery = entityManager.createQuery("FROM Student ORDER BY lastName ASC", Student.class);

    // return query results
    return theQuery.getResultList();
  }

  @Override
  public List<Student> findByLastName(String theLastName) {

    TypedQuery<Student> theQuery = entityManager.createQuery("FROM Student WHERE lastName=:theData", Student.class);

    theQuery.setParameter("theData", theLastName);

    return theQuery.getResultList();
  }

  @Override
  @Transactional
  public void update(Student theStudent) {
    entityManager.merge(theStudent);
  }

  @Override
  @Transactional
  public void delete(Integer id) {
    // retrieve the student
    Student student = entityManager.find(Student.class, id);

    entityManager.remove(student);
  }

  @Override
  @Transactional
  public int deleteAll() {
    int numRowsDeleted = entityManager.createQuery("DELETE FROM Student").executeUpdate();

    return numRowsDeleted;
  }

}
