package com.ali.rest.webservices.restfulwebservices.versioning;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VersioningPersonController {

    @GetMapping("/v1/person")
    public PersonV1 getFirstVersionPerson() {
        return new PersonV1("Magnus Carlsen");
    }

    @GetMapping("/v2/person")
    public PersonV2 getSecondVersionPerson() {
        return new PersonV2(new Name("Ali", "Ahmed"));
    }
}
