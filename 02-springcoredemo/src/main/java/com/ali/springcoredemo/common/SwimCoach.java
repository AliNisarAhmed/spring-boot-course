package com.ali.springcoredemo.common;

// This class does not have @Component like other Coach classes
// because it uses @Configuration defined in SportConfig.java class
public class SwimCoach implements Coach {

  public SwimCoach() {
    System.out.println("In constructor: " + getClass().getSimpleName());
  }

  @Override
  public String getDailyWorkout() {
    return "Swim 1000 meters as a warm up";
  }

}
