package com.luv2code.springboot.demosecurity.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {
    @GetMapping("/showMyLoginPage")
    public String showLoginPage () {
//        return "plain-login";
        return "fancy-login";
    }
    @GetMapping("/leaders")
    public String showLeaders () {
        return "leaders";
    }
    @GetMapping("/systems")
    public String showSystems () {
        return "systems";
    }
    @GetMapping("/access-denied")
    public String showAccessDenied () {
        return "access-denied";
    }
}
