package com.ali.springcoredemo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.ali.springcoredemo.common.Coach;
import com.ali.springcoredemo.common.SwimCoach;

@Configuration
// @Configuration is used with @Bean to manually create beans out of classes
// Useful in cases where we do not have access to source code of a class
// where we cannot use @Component
// Example: Amazon S3 Client SDK class
public class SportConfig {

  @Bean("awesomeSwimCoach")
  // bean id if not provided defaults to the method name, hence: "swimCoach"
  public Coach swimCoach() {
    return new SwimCoach();
  }
}
