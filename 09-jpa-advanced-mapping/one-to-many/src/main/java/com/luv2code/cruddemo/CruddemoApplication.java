package com.luv2code.cruddemo;

import com.luv2code.cruddemo.dao.AppDAO;
import com.luv2code.cruddemo.entity.Course;
import com.luv2code.cruddemo.entity.Instructor;
import com.luv2code.cruddemo.entity.InstructorDetail;
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
	public CommandLineRunner commandLineRunner(AppDAO appDAO) {
		return runner -> {
			//createInstructor(appDAO);

			//findInstructor(appDAO);

			//deleteInstructor(appDAO);
			//findInstructorDetail(appDAO);
			//deleteInstructorDetail(appDAO);
			//createInstructorWithCourse(appDAO);
			//findInstructorWithCourse(appDAO);
			findCourseForInstructor(appDAO);
		};
	}

	private void findCourseForInstructor (AppDAO appDAO) {
		// set id
		int theId = 1;
		// find instructor by id
		Instructor tempInstructor = appDAO.findInstructorById(theId);
		// print instructor
		System.out.println("tempInstructor: " + tempInstructor);
		// find course by instructor id
		List<Course> tempCourses = appDAO.findCourseByInstructorId(theId);
		// map instructor with course
		tempInstructor.setCourses(tempCourses);
		// print course
		System.out.println("the associated courses: " + tempInstructor.getCourses());
	}

	private void findInstructorWithCourse (AppDAO appDAO) {
		// set id
		int theId = 1;
		// find instructor by id
		Instructor tempInstructor = appDAO.findInstructorById(theId);
		// print instructor & course
		System.out.println("tempInstructor: " + tempInstructor);
		System.out.println("the associated courses: " + tempInstructor.getCourses());
	}

	private void createInstructorWithCourse (AppDAO appDAO) {
		Instructor tempInstructor =
				new Instructor("Susan", "Public", "susan.public@lu2code.com");
		InstructorDetail tempInstructorDetail =
				new InstructorDetail("http://www.youtube.com","Video games");

		tempInstructor.setInstructorDetail(tempInstructorDetail);

		// new courses
		Course tempCourse1 = new Course("Air Guitar - The Ultimate Edition Guide");
		Course tempCourse2 = new Course("The Pinball Masterclass");
		// instructor add course
		tempInstructor.add(tempCourse1);
        tempInstructor.add(tempCourse2);

		// add instructor to database
		appDAO.save(tempInstructor);
	}

	private void deleteInstructorDetail (AppDAO appDAO) {
		int theId = 3;
		System.out.println("Deleting instructor detail id: " + theId);
		appDAO.deleteInstructorDetailById(theId);
		System.out.println("Done!");
	}

	private void findInstructorDetail (AppDAO appDAO) {
		int theId = 2;
		System.out.println("Finding instructor id: " + theId);
		InstructorDetail theInstructorDetail = appDAO.findInstructorDetailById(theId);
		System.out.println("tempInstructorDetail: " + theInstructorDetail);
		System.out.println("the associated instructor: " + theInstructorDetail.getInstructor());
	}

	private void deleteInstructor (AppDAO appDAO) {
		int theId = 1;
        System.out.println("Deleting instructor id: " + theId);
        appDAO.deleteInstructorById(theId);
        System.out.println("Done!");
	}

	private void findInstructor (AppDAO appDAO) {
		int theId = 2;
		System.out.println("Finding instructor id: " + theId);
		Instructor theInstructor = appDAO.findInstructorById(theId);
		System.out.println("tempInstructor: " + theInstructor);
		System.out.println("the associated instructorDetail only: " + theInstructor.getInstructorDetail());
	}

	private void createInstructor (AppDAO appDAO) {
//		Instructor tempInstructor =
//		new Instructor("Chad", "Darby", "darby@lu2code.com");
//		InstructorDetail tempInstructorDetail =
//		new InstructorDetail("http://www.luv2code.com/youtube","luv2code");

		Instructor tempInstructor =
				new Instructor("Madhu", "Patel", "madhu@lu2code.com");
		InstructorDetail tempInstructorDetail =
				new InstructorDetail("http://www.luv2code.com/youtube","Guitar");

		tempInstructor.setInstructorDetail(tempInstructorDetail);
		System.out.println("Saving instructor: " + tempInstructor);
		appDAO.save(tempInstructor);
		System.out.println("Done!");
	}
}
