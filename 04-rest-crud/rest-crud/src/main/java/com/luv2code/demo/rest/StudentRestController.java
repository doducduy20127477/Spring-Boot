package com.luv2code.demo.rest;

import com.luv2code.demo.entity.Student;
import jakarta.annotation.PostConstruct;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestController {
    private List<Student> theStudents;

    @PostConstruct
    public void loadData() {
        theStudents = new ArrayList<Student>();
        theStudents.add(new Student("Poornima", "Patel"));
        theStudents.add(new Student("Mario", "Rossi"));
        theStudents.add(new Student("Mary", "Patel"));
    }

    @RequestMapping("/students")
    public List<Student> getStudents() {
        return theStudents;
    }
    @RequestMapping("/students/{studentID}")
    public Student getStudent(@PathVariable int studentID) {

        if ((studentID >= theStudents.size()) || (studentID < 0)) {
            throw new StudentNotFoundException("Student not found - " + studentID);
        }

        return theStudents.get(studentID);
    }


}