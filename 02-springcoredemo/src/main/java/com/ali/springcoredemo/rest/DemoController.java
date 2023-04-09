package com.ali.springcoredemo.rest;

import com.ali.springcoredemo.common.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    private Coach myCoach;
    private Coach anotherCoach;

    @Autowired
    //    public DemoController(@Qualifier("cricketCoach") Coach theCoach) {
    // Coach will default to Primary if Qualifier not used
    public DemoController(Coach theCoach, Coach theAnotherCoach) {
        myCoach = theCoach;
        anotherCoach = theAnotherCoach;
    }

    @GetMapping("/dailyworkout")
    public String getDailyWorkout() {
        return myCoach.getDailyWorkout();
    }

    @GetMapping("/check")
    public String check() {
        // this line will return true for singleton bean scope, false for prototype scope
        return "Comparing beans: myCoach == anotherCoach, " + (myCoach == anotherCoach);
    }

}
