package com.ali.springcoredemo.common;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

@Component // marks the class as a Spring bean for Injection
@Primary // marks this Object as the Primary implementation for the Interface
// @Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE) 
// sets the scope to be of prototype
// Prototype beans
//    - Lazy by default (no need for @Lazy)
//    - Spring does not call destroy method for them
// Default Scope is Singleton
public class CricketCoach implements Coach {

    public CricketCoach() {
        System.out.println("In constructor: " + getClass().getSimpleName());
    }

    @PostConstruct
    public void doMyStartupStuff() {
        System.out.println("In doMyStartupStuff: " + getClass().getSimpleName());
    }

    @PreDestroy
    public void doMyCleanupStuff() {
        System.out.println("In doMyCleanupStuff: " + getClass().getSimpleName());
    }

    @Override
    public String getDailyWorkout() {
        return "Practice fast bowling for 15 minutes";
    }
}
