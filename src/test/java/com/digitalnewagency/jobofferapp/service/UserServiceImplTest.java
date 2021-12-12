package com.digitalnewagency.jobofferapp.service;

import com.digitalnewagency.jobofferapp.commons.exception.NoDataFoundException;
import com.digitalnewagency.jobofferapp.model.entity.User;
import com.digitalnewagency.jobofferapp.model.repository.UserRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;


@ExtendWith(MockitoExtension.class)
class UserServiceImplTest {

    @Mock
    UserRepository repository;

    @InjectMocks
    UserServiceImpl userService;

    @Test
    @DisplayName("test if service returns user correct")
    void shouldReturnUserCorrect() {

        Mockito.when(repository.findById(Mockito.anyString())).thenReturn(Optional.of(new User()));

        var user = userService.getUser("test");

        org.assertj.core.api.Assertions.assertThat(user).isNotNull();

    }

    @Test
    @DisplayName("Test if service returns exception for not found user ")
    void shouldReturnExceptionWhenNotFound() {
        Mockito.when(repository.findById(Mockito.anyString())).thenReturn(Optional.empty());

        org.assertj.core.api.Assertions.assertThatThrownBy(() -> {
            userService.getUser("notFound");
        }).isInstanceOf(NoDataFoundException.class).hasMessage("User not found");

    }
}