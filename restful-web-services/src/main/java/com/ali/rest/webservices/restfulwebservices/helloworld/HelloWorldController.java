package com.ali.rest.webservices.restfulwebservices.helloworld;


import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Locale;

@RestController
public class HelloWorldController {

    private MessageSource messageSource;

    public HelloWorldController(MessageSource msgSource) {
        this.messageSource = msgSource;
    }

    @GetMapping("/hello-world")
    public String helloWorld() {
        return "Hello World";
    }

    @GetMapping("/hello-world-i18n")
    public String helloWorldI18n() {
        Locale locale = LocaleContextHolder.getLocale();
        return this.messageSource.getMessage("good.morning.message", null, "Default Message", locale);
    }
}
