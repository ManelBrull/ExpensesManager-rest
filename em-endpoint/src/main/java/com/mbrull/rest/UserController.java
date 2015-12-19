package com.mbrull.rest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mbrull.entities.User;

@RestController
public class UserController {

    @RequestMapping("/user")
    public User user(@RequestParam(value = "username", defaultValue = "") String username) {
        return new User(0, username);
    }

}
