package com.ali.rest.webservices.restfulwebservices.user;

import jakarta.validation.Valid;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
public class UserResource {

    private UserDaoService service;

    public UserResource(UserDaoService service) {
        this.service = service;
    }

    @GetMapping("/users")
    public List<User> getAllUsers() {
        return service.findAll();
    }

    @GetMapping("/users/{userId}")
    public EntityModel<User> retrieveUser(@PathVariable int userId) {

        User user = service.getUserById(userId);

        if (user == null) {
            throw new UserNotFoundException("id: " + userId);
        }

        EntityModel<User> entityModel = EntityModel.of(user);

        WebMvcLinkBuilder link = linkTo(methodOn(this.getClass()).getAllUsers());
        entityModel.add(link.withRel("all-users"));

        return entityModel;
    }

    @DeleteMapping("/users/{userId}")
    public User deleteUser(@PathVariable int userId) {

        User user = service.getUserById(userId);

        if (user == null) {
            throw new UserNotFoundException("id: " + userId);
        }

        service.deleteById(user.getId());

        return user;
    }

    @PostMapping("/users")
    public ResponseEntity<User> createUser(@Valid @RequestBody User user) {
        User savedUser = service.saveUser(user);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedUser.getId()).toUri();
        return ResponseEntity.created(location).build();
    }
}
