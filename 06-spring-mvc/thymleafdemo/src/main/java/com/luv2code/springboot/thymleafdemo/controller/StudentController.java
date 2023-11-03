package com.luv2code.springboot.thymleafdemo.controller;

import com.luv2code.springboot.thymleafdemo.model.Student;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class StudentController {
    @Value("${countries}")
    List<String> countries;
    @Value("${languages}")
    List<String> languages;
    @Value("${systems}")
    List<String> systems;
    @GetMapping("/showStudentForm")
    public String showForm(Model theModel)
    {
        Student theStudent = new Student();
        theModel.addAttribute("student", theStudent);
        theModel.addAttribute("countries", countries);
        theModel.addAttribute("languages", languages);
        theModel.addAttribute("systems", systems);
        return "student-form";
    }

    @PostMapping("/processStudentForm")
    public String processForm(@ModelAttribute("student") Student theStudent)
    {
        System.out.println(theStudent);
        return "student-confirmation";
    }
}
