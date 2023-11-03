package com.luv2code.springcoredemo.common;

import org.springframework.stereotype.Component;

@Component
public class CricketCoach implements Coach{
    public CricketCoach() {
        System.out.println("In constructor: " + this.getClass().getSimpleName());
    }

//    @PostConstruct
//    public void doMyStartupStuff(){
//        System.out.println("In doMyStartupStuff: " + this.getClass().getSimpleName());
//    }
//
//    @PreDestroy
//    public void doMyCleanupStuff(){
//        System.out.println("In doMyCleanupStuff: " + this.getClass().getSimpleName());
//    }
    @Override
    public String getDailyWorkout() {
        return "Practice fast bowling for 15 minutes";
    }
}
