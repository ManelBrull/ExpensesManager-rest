package com.mbrull.endpoint.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.mbrull.core.dto.UserDTO;
import com.mbrull.endpoint.EmEndpoint;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    EmEndpoint endpoint;

    // TODO: exception controlling and returning to client interface

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Void> createUser(@Validated @RequestBody UserDTO user, UriComponentsBuilder ucBuilder) {
        long userId = endpoint.createUser(user);

        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/user/{id}").build().expand(Long.toString(userId)).toUri());

        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    public ResponseEntity<UserDTO> findById(@PathVariable("id") long id) {
        return new ResponseEntity<UserDTO>(endpoint.getUser(id), HttpStatus.OK);
    }


}
