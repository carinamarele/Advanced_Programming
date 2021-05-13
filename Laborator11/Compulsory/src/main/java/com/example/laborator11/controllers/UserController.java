package com.example.laborator11.controllers;

import com.example.laborator11.entity.UserEntity;
import com.example.laborator11.services.UserEntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {
    private final UserEntityService userService;

    @Autowired
    public UserController(UserEntityService userService) {
        this.userService = userService;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/")
    public List<UserEntity> getUserList() {
        return userService.getAllUsers();
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/{id}")
    public UserEntity putUserName(@PathVariable long id, @RequestParam String name) {
        return userService.changeName(id, name);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "{id}")
    public void deleteUser(@PathVariable long id) {
        userService.deleteUser(id);
    }
    @RequestMapping(method = RequestMethod.POST, value = "/")
    public UserEntity createUser(@RequestBody UserEntity user) {
        return userService.addUser(user);
    }
}
