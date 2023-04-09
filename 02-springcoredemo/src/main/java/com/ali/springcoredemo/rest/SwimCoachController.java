package com.ali.springcoredemo.rest;

import com.ali.springcoredemo.common.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SwimCoachController {
  private Coach myCoach;

  @Autowired
  public SwimCoachController(@Qualifier("awesomeSwimCoach") Coach swimCoach) {
    myCoach = swimCoach;
  }

  @GetMapping("/dailyworkout/swim")
  public String getDailySwimWorkout() {
    return myCoach.getDailyWorkout();
  }
}
