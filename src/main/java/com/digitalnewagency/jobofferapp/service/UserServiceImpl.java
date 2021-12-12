package com.digitalnewagency.jobofferapp.service;

import com.digitalnewagency.jobofferapp.commons.exception.NoDataFoundException;
import com.digitalnewagency.jobofferapp.model.entity.User;
import com.digitalnewagency.jobofferapp.model.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private UserRepository repository;

    @Override
    public User getUser(String login) {
        return repository.findById(login).orElseThrow(() -> {
            throw new NoDataFoundException("User not found");
        });
    }

    @Override
    public User createUser(User user) {
        return repository.save(user);
    }

    @Override
    public void updateUser(User user) {
        User userByName = repository.findById(user.getLogin()).orElseThrow(() -> {
            throw new NoDataFoundException("User not found");
        });
        userByName.setPassword(user.getPassword());
        userByName.setName(user.getName());

        repository.save(userByName);
    }

    @Override
    public void deleteUser(String login) {
        if (!repository.existsById(login)) {
            throw new NoDataFoundException("User not found");
        }
        repository.deleteById(login);
    }
}
