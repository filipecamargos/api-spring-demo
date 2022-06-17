package com.apps.developerblog.app.ws.tutorial.ui.controller;

import com.apps.developerblog.app.ws.tutorial.ui.model.request.UserDetailsRequestModel;
import com.apps.developerblog.app.ws.tutorial.ui.model.response.UserRest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;

@RestController
@RequestMapping("users")
public class UserController {
    @GetMapping()
    public String getUsers(@RequestParam(value = "page", defaultValue = "1") int page,
                           @RequestParam(value = "limit", defaultValue = "50") int limit,
                           @RequestParam(value = "sort", defaultValue = "asc", required = false) String sort) {

        return String.format("Get user called page: %s, limit: %s , sort: %s", page, limit, sort);
    }


    @GetMapping(path = "/{userID}",
            produces = {
                    MediaType.APPLICATION_ATOM_XML_VALUE,
                    MediaType.APPLICATION_JSON_VALUE}
    )
    public ResponseEntity<UserRest> getUser(@PathVariable String userID) {
        UserRest returnUser = new UserRest("TestFirstName", "TestLastName",
                "test@test.com", null);
        return new ResponseEntity<UserRest>(returnUser, HttpStatus.OK);
    }

    @PostMapping(
            consumes = {
                    MediaType.APPLICATION_ATOM_XML_VALUE,
                    MediaType.APPLICATION_JSON_VALUE},
            produces = {
                    MediaType.APPLICATION_ATOM_XML_VALUE,
                    MediaType.APPLICATION_JSON_VALUE}
    )
    public ResponseEntity<UserRest> createUser(@Valid @RequestBody UserDetailsRequestModel userDetails) {
        UserRest createdUser = new UserRest(userDetails.getFirstName(), userDetails.getFirstName(), userDetails.getEmail(), null);
        return new ResponseEntity<UserRest>(createdUser, HttpStatus.OK);
    }

    @PutMapping
    public String updateUser() {
        return "User Updated";
    }

    @DeleteMapping
    public String deleteUser() {
        return "User Deleted";
    }
}
