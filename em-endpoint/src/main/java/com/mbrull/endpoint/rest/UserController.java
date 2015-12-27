package com.mbrull.endpoint.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public ResponseEntity<Void> createUser(@RequestBody UserDTO user, UriComponentsBuilder ucBuilder) {

        endpoint.createUser(user);

        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/create/success").build().toUri());

        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }
    /*
     * @RequestMapping("/user/") public ResponseEntity<String> user() { long
     * count = emPersistence.countUsers(); return new ResponseEntity<String>(
     * "There are " + count + " users enrolled", HttpStatus.OK); }
     * 
     * @RequestMapping(value = "/user/all", method = RequestMethod.GET) public
     * ResponseEntity<Page<User>> getUsers(Pageable pageRequest) { Page<User>
     * users = emPersistence.getUsers(pageRequest); return new
     * ResponseEntity<Page<User>>(users, HttpStatus.OK); }
     * 
     * @RequestMapping("/user/{id}") public ResponseEntity<Optional<User>>
     * findById(@PathVariable("id") Long id) { return new
     * ResponseEntity<Optional<User>>(emPersistence.getUser(id), HttpStatus.OK);
     * }
     * 
     * @RequestMapping("/user/like/{username}") public
     * ResponseEntity<List<User>> findByUsernameLike(@PathVariable("username")
     * String username) { List<User> entries =
     * emPersistence.findUsersWithSimiliarUsername(username); return new
     * ResponseEntity<List<User>>(entries, HttpStatus.OK); }
     * 
     * 
     * 
     * @RequestMapping("/init/") public ResponseEntity<Void> initdatabase() {
     * emPersistence.initDatabase(); return new
     * ResponseEntity<Void>(HttpStatus.OK); }
     */
}
