package com.digitalnewagency.jobofferapp.web.converter;

import com.digitalnewagency.jobofferapp.commons.exception.WrongParameterException;
import com.digitalnewagency.jobofferapp.testdata.UserFactory;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


class UserConverterTest {


    private UserConverter converter = new UserConverter();


    @Test
    @DisplayName("test if  converter return  userDTO correct")
    void shouldReturnUserDTOCorrect() {

        var result = converter.convertUserToUserDTO(UserFactory.createUser());

        Assertions.assertThat(result).isNotNull();
        Assertions.assertThat(result.getLogin()).isEqualTo("test");
        Assertions.assertThat(result.getName()).isEqualTo("testName");

    }

    @Test
    @DisplayName("test if  converter return  user correct")
    void shouldReturnUserCorrect() {

        var result = converter.convertUserDTOtoUser(UserFactory.createUserDTO());

        Assertions.assertThat(result).isNotNull();
        Assertions.assertThat(result.getLogin()).isEqualTo("test");
        Assertions.assertThat(result.getName()).isEqualTo("testName");

    }

    @Test
    @DisplayName("test if converter return exception when null given")
    void shouldReturnExceptionWhenNullGiven() {
        Assertions.assertThatThrownBy(() -> {
            converter.convertUserDTOtoUser(null);
        }).isInstanceOf(WrongParameterException.class).hasMessage("User cannot be null");
    }
}