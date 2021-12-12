package com.digitalnewagency.jobofferapp.web.controller;

import com.digitalnewagency.jobofferapp.model.entity.User;
import com.digitalnewagency.jobofferapp.web.dto.user.UserDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping(value = "/dna/users", produces = "application/json")
public interface UserController {

    @GetMapping(value = "/{login}")
    ResponseEntity<User> getUser(@PathVariable String login);

    @PostMapping
    ResponseEntity<?> createUser(@RequestBody UserDTO userDTO);

    @PutMapping
    ResponseEntity<?> updateUser(@RequestBody UserDTO userDTO);

    @DeleteMapping(value = "/{login}")
    ResponseEntity<?> deleteUser(@PathVariable String login);

}
