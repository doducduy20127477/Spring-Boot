package com.luv2code.springboot.thymleafdemo.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloWorldController {
@RequestMapping("/showForm")
    public String showForm(){
        return "helloworld-form";
    }
    @RequestMapping("/processForm")
    public String processForm(){
        return "helloworld";
    }
    @RequestMapping("/processFormVersionTwo")
    public String letsShoutDude(HttpServletRequest request, Model model){
        String theName = request.getParameter("studentName");
        theName = theName.toUpperCase();
        String result = "Yo!" + theName;
        model.addAttribute("message", result);
        return "helloworld";
    }
    @RequestMapping("/processFormVersionThree")
    public String processForm(@RequestParam("studentName") String theName, Model model){
        theName = theName.toUpperCase();
        String result = "hey my friend from v3!" + theName;
        model.addAttribute("message", result);
        return "helloworld";
    }
}
