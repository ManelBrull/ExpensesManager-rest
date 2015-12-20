package com.mbrull.rest;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.mbrull.entities.User;
import com.mbrull.repository.UserRepository;

@RestController
public class UserController {

    @Autowired
    UserRepository repository;

    @RequestMapping("/user/")
    public ResponseEntity<String> user(@RequestParam(value = "username", defaultValue = "") String username) {
        long count = repository.count();
        return new ResponseEntity<String>("There are " + count + " users enrolled", HttpStatus.OK);
    }

    @RequestMapping("/user/{id}")
    public ResponseEntity<Optional<User>> findById(@PathVariable("id") Long id) {
        return new ResponseEntity<Optional<User>>(repository.findOne(id), HttpStatus.OK);
    }

    @RequestMapping(value = "/user/", method = RequestMethod.POST)
    public ResponseEntity<Void> createUser(@RequestBody String username, UriComponentsBuilder ucBuilder) {
        System.out.println("Creating User " + username);

        if (repository.findByUsernameIgnoreCase(username).isPresent()) {
            return new ResponseEntity<Void>(HttpStatus.CONFLICT);
        }
        
        User user = new User(username);
        repository.save(user);

        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/user/{id}").buildAndExpand(user.getId()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }

}
