package com.example.spring_core_demo.rest;

import com.example.spring_core_demo.common.Coach.Coach;
import com.example.spring_core_demo.common.Sports;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    Sports mySport;
    Sports anotherSport;

    // define a private field for the dependency
//    @Autowired // field injection
    private Coach myCoach;

    // define a constructor for dependency injection
    @Autowired
//    public DemoController(Coach theCoach){
    public DemoController(@Qualifier("cricketCoach") Coach theCoach){
//    public DemoController(@Qualifier("aquatic") Coach theCoach){
        myCoach = theCoach;
        System.out.println("In Constructor: " + getClass().getSimpleName());
    }

//    @Autowired
    public DemoController(Sports mySport, Sports anotherSport){
        this.mySport = mySport;
        this.anotherSport = anotherSport;
    }

    // setter injection
/*    @Autowired
    public void setCoach(Coach theCoach) {
        this.myCoach = theCoach;
    }*/

    @GetMapping("/dailyworkout")
    public String getDailyWorkout(){
        return myCoach.getDailyWorkOut();
    }

    @GetMapping("/check")
    public String checkBean(){
        return "Comparing beans: mySport == anotherSport, " + (mySport == anotherSport);
    }

}
