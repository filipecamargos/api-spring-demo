package com.apps.developerblog.app.ws.tutorial.ui.controller;

import com.apps.developerblog.app.ws.tutorial.ui.model.request.UpdateUserRequestModel;
import com.apps.developerblog.app.ws.tutorial.ui.model.request.UserDetailsRequestModel;
import com.apps.developerblog.app.ws.tutorial.ui.model.response.UserRest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.function.EntityResponse;

import javax.swing.text.html.parser.Entity;
import javax.validation.Valid;
import java.util.*;

@RestController
@RequestMapping("users")
public class UserController {

    private Map<String, UserRest> users;

    @GetMapping()
    public ResponseEntity getUsers(@RequestParam(value = "page", defaultValue = "1") int page,
                                         @RequestParam(value = "limit", defaultValue = "50") int limit,
                                         @RequestParam(value = "sort", defaultValue = "asc", required = false) String sort) {

        if (users == null) return new ResponseEntity<List>(List.of(), HttpStatus.OK);
        List<UserRest> returnList = new ArrayList<UserRest>(users.values());
        return new ResponseEntity<List>(returnList, HttpStatus.OK);
    }


    @GetMapping(path = "/{userID}",
            produces = {
                    MediaType.APPLICATION_ATOM_XML_VALUE,
                    MediaType.APPLICATION_JSON_VALUE}
    )
    public ResponseEntity getUser(@PathVariable String userID) {

        if (users == null) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        if (users.containsKey((userID))) {
            return new ResponseEntity<UserRest>(users.get(userID), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }

    @PostMapping(
            consumes = {
                    MediaType.APPLICATION_ATOM_XML_VALUE,
                    MediaType.APPLICATION_JSON_VALUE},
            produces = {
                    MediaType.APPLICATION_ATOM_XML_VALUE,
                    MediaType.APPLICATION_JSON_VALUE}
    )
    public ResponseEntity createUser(@Valid @RequestBody UserDetailsRequestModel userDetails) {
        UserRest createdUser = new UserRest(userDetails.getFirstName(), userDetails.getFirstName(), userDetails.getEmail(), null);

        String userId = UUID.randomUUID().toString();
        createdUser.setUserId((userId));

        if(users == null) users = new HashMap<>();
        users.put(userId, createdUser);

        return new ResponseEntity<UserRest>(createdUser, HttpStatus.OK);
    }

    @PutMapping(path = "/{userID}",
            consumes = {
                    MediaType.APPLICATION_ATOM_XML_VALUE,
                    MediaType.APPLICATION_JSON_VALUE},
            produces = {
                    MediaType.APPLICATION_ATOM_XML_VALUE,
                    MediaType.APPLICATION_JSON_VALUE}
    )
    public ResponseEntity updateUser(@PathVariable String userID, @Valid @RequestBody UpdateUserRequestModel userDetails) {
        UserRest userToUpdate = users.get(userID);

        if (userToUpdate == null) return ResponseEntity.notFound().build();

        userToUpdate.setFirstName(userDetails.getFirstName());
        userToUpdate.setLastName(userDetails.getLastName());
        return new ResponseEntity<UserRest>(userToUpdate, HttpStatus.OK);
    }

    @DeleteMapping(path = "/{userID}")
    public ResponseEntity deleteUser(@PathVariable String userID) {
        if (!users.containsKey(userID)) {
                return ResponseEntity.notFound().build();
        }
        users.remove(userID);
        return ResponseEntity.noContent().build();
    }
}
