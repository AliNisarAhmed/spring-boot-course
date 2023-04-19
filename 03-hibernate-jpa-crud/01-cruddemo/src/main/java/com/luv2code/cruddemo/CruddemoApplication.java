package com.luv2code.cruddemo;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.luv2code.cruddemo.dao.StudentDAO;
import com.luv2code.cruddemo.entity.Student;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO) {
		return runner -> {
			// createStudent(studentDAO);

			// createMultipleStudents(studentDAO);

			// readStudent(studentDAO);

			// queryForStudents(studentDAO);

			// queryForStudentsByLastName(studentDAO);

			// updateStudent(studentDAO);

			// deleteStudent(studentDAO);

			deleteAllStudents(studentDAO);
		};
	}

	private void deleteAllStudents(StudentDAO studentDAO) {
		System.out.println("Deleting all students");
		int numRowsDeleted = studentDAO.deleteAll();

		System.out.println("Deleted %s rows".formatted(numRowsDeleted));

	}

	private void deleteStudent(StudentDAO studentDAO) {
		int studentId = 3;
		System.out.println("Deleting student id: " + studentId);
		studentDAO.delete(studentId);
	}

	private void updateStudent(StudentDAO studentDAO) {
		// retrieve student based on id: primary key
		int studentId = 2;
		System.out.println("Getting student with id: " + studentId);
		Student myStudent = studentDAO.findById(studentId);

		// change last name
		myStudent.setLastName("Ahmed");

		// update the student
		studentDAO.update(myStudent);

		System.out.println("Updated Student: " + myStudent);
	}

	private void queryForStudentsByLastName(StudentDAO studentDAO) {
		List<Student> students = studentDAO.findByLastName("Ali");

		for (Student student : students) {
			System.out.println(student);
		}
	}

	private void queryForStudents(StudentDAO studentDAO) {
		List<Student> students = studentDAO.findAll();

		for (Student tempStudent : students) {
			System.out.println(tempStudent);
		}
	}

	private void readStudent(StudentDAO studentDAO) {
		// create student
		System.out.println("Creating teh new student object");
		Student tempStudent = new Student("Arshi", "Nisar", "arshi@world.com");

		// save the student
		studentDAO.save(tempStudent);
		int studentId = tempStudent.getId();
		System.out.println("Saved student. Generated id: " + studentId);

		// display student
		Student storedStudent = studentDAO.findById(studentId);
		System.out.println("Found the student: " + storedStudent);
	}

	private void createMultipleStudents(StudentDAO studentDAO) {

		// create students
		System.out.println("Creating teh new student object");
		Student tempStudent1 = new Student("Ali", "Ali", "ali@world.com");
		Student tempStudent2 = new Student("Samrah", "Akber", "samrah@world.com");
		Student tempStudent3 = new Student("Azlan", "Ali", "azlan@world.com");

		// save the students
		System.out.println("Saving the students");
		studentDAO.save(tempStudent1);
		studentDAO.save(tempStudent2);
		studentDAO.save(tempStudent3);
	}

	private void createStudent(StudentDAO studentDAO) {
		// create student
		System.out.println("Creating teh new student object");
		Student tempStudent = new Student("Paul", "Doe", "paul@world.com");

		// save the student
		System.out.println("Saving the student...");
		studentDAO.save(tempStudent);

		// display id of the saved student
		System.out.println("Save Student. Generated Id: " + tempStudent.getId());
	}

}
