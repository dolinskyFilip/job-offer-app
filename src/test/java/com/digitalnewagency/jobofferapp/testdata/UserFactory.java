package com.digitalnewagency.jobofferapp.testdata;

import com.digitalnewagency.jobofferapp.model.entity.User;
import com.digitalnewagency.jobofferapp.web.dto.user.UserDTO;

import java.time.LocalDateTime;

public class UserFactory {

    public static User createUser(){
        User user= new User();
        user.setLogin("test");
        user.setPassword("setPassword");
        user.setName("testName");
        user.setAccountCreationDate(LocalDateTime.of(2021, 12, 1, 12, 00));

        return user;
    }
    public static UserDTO createUserDTO(){
        UserDTO user= new UserDTO();
        user.setLogin("test");
        user.setPassword("setPassword");
        user.setName("testName");
        user.setAccountCreationDate(LocalDateTime.of(2021, 12, 1, 12, 00));
        return user;
    }
}
