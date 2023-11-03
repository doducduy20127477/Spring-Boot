package com.luv2code.springcoredemo.rest;

import com.luv2code.springcoredemo.common.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {
    private Coach myCoach;
    @Autowired
    public DemoController(
            @Qualifier("swimCoach") Coach coach){
        System.out.println("In constructor: " + this.getClass().getSimpleName());
        this.myCoach = coach;
    }

//    @Autowired
//    public void setCoach(Coach coach) {
//        this.myCoach = coach;
//    }

    @GetMapping("/dailyworkout")
    public String getDailyWorkout(){
        return myCoach.getDailyWorkout();
    }

//    @GetMapping("/check")
//    public String check(){
//        return "Comparing beans: myCoach == anotherCoach, " + (myCoach == anotherCoach);
//    }
}
