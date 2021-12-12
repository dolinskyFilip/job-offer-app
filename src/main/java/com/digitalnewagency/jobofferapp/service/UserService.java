package com.digitalnewagency.jobofferapp.service;

import com.digitalnewagency.jobofferapp.model.entity.User;

public interface UserService {

    User getUser(String login);

    User createUser(User user);

    void updateUser(User user);

    void deleteUser(String login);

}
