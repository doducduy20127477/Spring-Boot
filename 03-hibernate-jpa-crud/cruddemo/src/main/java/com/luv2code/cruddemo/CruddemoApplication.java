package com.luv2code.cruddemo;

import com.luv2code.cruddemo.dao.StudentDAO;
import com.luv2code.cruddemo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO) {
		return runner -> {
			//createStudent(studentDAO);

			createMultipleStudents(studentDAO);

			//readStudent(studentDAO);

			//queryForStudents(studentDAO);

			//queryForStudentsByLastName(studentDAO);
			//updateStudent(studentDAO);
            //deleteStudent(studentDAO);
            //deleteAllStudents(studentDAO);
		};
	}

	private void deleteAllStudents(StudentDAO studentDAO) {
		System.out.println("Deleting all students");
		int numRowsDeleted = studentDAO.deleteAll();
		System.out.println("Deleted row count: " + numRowsDeleted);
	}

	private void deleteStudent(StudentDAO studentDAO) {
		int studentId = 3;
        System.out.println("Delete with id: " + studentId);
        studentDAO.delete(studentId);
	}

	private void updateStudent(StudentDAO studentDAO) {
		int studentId = 1;
		System.out.println("Getting student with id: " + studentId);
		Student myStudent = studentDAO.findById(studentId);
		System.out.println("Updating student...");
		myStudent.setFirstName("Paul");
		studentDAO.update(myStudent);
		System.out.println("Updated student: " + myStudent);


	}

	private void queryForStudentsByLastName(StudentDAO studentDAO) {
		List<Student> students = studentDAO.findByLastName("Doe");
        students.forEach(System.out::println);
	}

	private void queryForStudents(StudentDAO studentDAO) {
		List<Student> students = studentDAO.findAll();
        students.forEach(System.out::println);
	}

	private void readStudent(StudentDAO studentDAO) {
		System.out.println("Creating new student object...");
		Student student = new Student("Daffy", "Duck", "Daffy@luv2code.com");
		System.out.println("Saving the student...");
		studentDAO.save(student);
		System.out.println("Saved Student. Generate id: " + student.getId());

		int theId = student.getId();
		System.out.println("Retrieving student with id: " + theId);
		Student studentRetrieved = studentDAO.findById(theId);
		System.out.println("Found the student: " + studentRetrieved);

	}

	private void createMultipleStudents(StudentDAO studentDAO) {
		System.out.println("Creating 3 students object...");
		Student student1 = new Student("John", "Doe", "John@luv2code.com");
		Student student2 = new Student("Mary", "Public", "Mary@luv2code.com");
		Student student3 = new Student("Bonita", "Appleum", "Bonita@luv2code.com");

		System.out.println("Saving the student...");
		studentDAO.save(student1);
		studentDAO.save(student2);
		studentDAO.save(student3);
	}

	private void createStudent(StudentDAO studentDAO) {
		System.out.println("Creating new student object...");
		Student student = new Student("Paul", "Doe", "paul@luv2code.com");
		System.out.println("Saving the student...");
		studentDAO.save(student);
		System.out.println("Saved Student. Generate id: " + student.getId());

	}

}
