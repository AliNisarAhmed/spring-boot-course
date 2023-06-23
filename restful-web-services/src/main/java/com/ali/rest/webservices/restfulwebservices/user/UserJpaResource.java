package com.ali.rest.webservices.restfulwebservices.user;

import com.ali.rest.webservices.restfulwebservices.jpa.UserRepository;
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
import java.util.Optional;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
public class UserJpaResource {

    private UserDaoService service;
    private UserRepository repository;

    public UserJpaResource(UserDaoService service, UserRepository repository) {
        this.service = service;
        this.repository = repository;
    }

    @GetMapping("/jpa/users")
    public List<User> getAllUsers() {
        return repository.findAll();
    }

    @GetMapping("/jpa/users/{userId}")
    public EntityModel<User> retrieveUser(@PathVariable int userId) {

        Optional<User> user = repository.findById(userId);

        if (user.isEmpty()) {
            throw new UserNotFoundException("id: " + userId);
        }

        EntityModel<User> entityModel = EntityModel.of(user.get());

        WebMvcLinkBuilder link = linkTo(methodOn(this.getClass()).getAllUsers());
        entityModel.add(link.withRel("all-users"));

        return entityModel;
    }

    @DeleteMapping("/jpa/users/{userId}")
    public User deleteUser(@PathVariable int userId) {

        Optional<User> user = repository.findById(userId);

        if (user.isEmpty()) {
            throw new UserNotFoundException("id: " + userId);
        }

        repository.deleteById(user.get().getId());

        return user.get();
    }

    @PostMapping("/jpa/users")
    public ResponseEntity<User> createUser(@Valid @RequestBody User user) {
        User savedUser = repository.save(user);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedUser.getId()).toUri();
        return ResponseEntity.created(location).build();
    }
}
