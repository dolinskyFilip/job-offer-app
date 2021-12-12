package com.digitalnewagency.jobofferapp.web.converter;

import com.digitalnewagency.jobofferapp.commons.exception.WrongParameterException;
import com.digitalnewagency.jobofferapp.model.entity.User;
import com.digitalnewagency.jobofferapp.web.dto.user.UserDTO;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class UserConverter {

    public User convertUserDTOtoUser(UserDTO userDTO) {
        if (userDTO == null) throw new WrongParameterException("User cannot be null");
        User user = new User();
        user.setLogin(userDTO.getLogin());
        user.setPassword(userDTO.getPassword());
        user.setName(userDTO.getName());
        user.setAccountCreationDate(LocalDateTime.now());
        return user;
    }

    public UserDTO convertUserToUserDTO(User user) {
        UserDTO userDTO = new UserDTO();
        userDTO.setLogin(user.getLogin());
        userDTO.setName(user.getName());
        userDTO.setAccountCreationDate(user.getAccountCreationDate());
        return userDTO;
    }
}
