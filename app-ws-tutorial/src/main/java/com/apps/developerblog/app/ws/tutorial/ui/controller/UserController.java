package com.apps.developerblog.app.ws.tutorial.ui.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("users")
public class UserController {

    @GetMapping
    public String getUser() {
        return "User Called";
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
