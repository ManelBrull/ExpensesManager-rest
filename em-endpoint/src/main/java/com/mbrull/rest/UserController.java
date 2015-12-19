package com.mbrull.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mbrull.entities.User;
import com.mbrull.repository.UserRepository;

@RestController
public class UserController {

    @Autowired
    UserRepository respository;

    @RequestMapping("/user")
    public ResponseEntity<User> user(@RequestParam(value = "username", defaultValue = "") String username) {
        return new ResponseEntity<User>(new User(0, username), HttpStatus.OK);
    }

    @RequestMapping("/user/{username}")
    public ResponseEntity<List<User>> findAllUsername(@PathVariable("username") String username) {
        return new ResponseEntity<List<User>>(respository.findByUsername(username), HttpStatus.OK);
    }

}
