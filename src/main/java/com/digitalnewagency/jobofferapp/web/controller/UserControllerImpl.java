package com.digitalnewagency.jobofferapp.web.controller;

import com.digitalnewagency.jobofferapp.model.entity.User;
import com.digitalnewagency.jobofferapp.service.UserService;
import com.digitalnewagency.jobofferapp.web.converter.UserConverter;
import com.digitalnewagency.jobofferapp.web.dto.user.UserDTO;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class UserControllerImpl implements UserController {

    private UserService service;

    private UserConverter converter;

    @Override
    public ResponseEntity<User> getUser(String login) {
        var user = service.getUser(login);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<?> createUser(UserDTO request) {
        var user= converter.convertUserDTOtoUser(request);
        var userSaved = service.createUser(user);
        var result= converter.convertUserToUserDTO(userSaved);
        return new ResponseEntity<>(result, HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<?> updateUser(UserDTO request) {
        var user= converter.convertUserDTOtoUser(request);
        var userUpdated = service.createUser(user);
        service.updateUser(userUpdated);
        return ResponseEntity.noContent().build();
    }

    @Override
    public ResponseEntity<?> deleteUser(String login) {
        service.deleteUser(login);
        return ResponseEntity.noContent().build();
    }
}
