package com.mbrull.rest;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.mbrull.EmPersistence;
import com.mbrull.entities.User;

@RestController
public class UserController {

    @Autowired
    EmPersistence emPersistence;

    @RequestMapping("/user/")
    public ResponseEntity<String> user() {
        long count = emPersistence.countUsers();
        return new ResponseEntity<String>("There are " + count + " users enrolled", HttpStatus.OK);
    }

    @RequestMapping(value = "/user/all", method = RequestMethod.GET)
    public ResponseEntity<Page<User>> getUsers(Pageable pageRequest) {
        Page<User> users = emPersistence.getUsers(pageRequest);
        return new ResponseEntity<Page<User>>(users, HttpStatus.OK);
    }

    @RequestMapping("/user/{id}")
    public ResponseEntity<Optional<User>> findById(@PathVariable("id") Long id) {
        return new ResponseEntity<Optional<User>>(emPersistence.getUser(id), HttpStatus.OK);
    }

    @RequestMapping("/user/like/{username}")
    public ResponseEntity<List<User>> findByUsernameLike(@PathVariable("username") String username) {
        List<User> entries = emPersistence.findUsersWithSimiliarUsername(username);
        return new ResponseEntity<List<User>>(entries, HttpStatus.OK);
    }

    @RequestMapping(value = "/user/", method = RequestMethod.POST)
    public ResponseEntity<Void> createUser(@RequestBody String username, UriComponentsBuilder ucBuilder) {

        User user = new User(username);
        emPersistence.createUser(user);

        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/user/{id}").buildAndExpand(user.getId()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }

    @RequestMapping("/init/")
    public ResponseEntity<Void> initdatabase() {
        emPersistence.initDatabase();
        return new ResponseEntity<Void>(HttpStatus.OK);
    }

}
