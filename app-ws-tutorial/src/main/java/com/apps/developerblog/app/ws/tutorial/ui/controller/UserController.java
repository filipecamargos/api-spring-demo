package com.apps.developerblog.app.ws.tutorial.ui.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("users")
public class UserController {
    @GetMapping()
    public String getUsers(@RequestParam(value = "page", defaultValue = "1") int page,
                           @RequestParam(value = "limit", defaultValue = "50") int limit,
                           @RequestParam(value = "sort", defaultValue = "asc", required = false ) String sort) {

        return String.format("Get user called page: %s, limit: %s , sort: %s", page, limit, sort);
    }

    @GetMapping(path = "/{userID}")
    public String getUser(@PathVariable String userID) {
        return "User Called " + userID;
    }

    @PostMapping
    public String createUser() {
        return  "User Created";
    }

    @PutMapping
    public String updateUser() {
        return  "User Updated";
    }

    @DeleteMapping
    public  String deleteUser() {
        return "User Deleted";
    }
}
