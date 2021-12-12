package com.digitalnewagency.jobofferapp.web.dto.user;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Data
public class UserDTO {

    @NotBlank
    @NotNull
    private String login;

    @NotBlank
    @NotNull
    private String password;

    @NotBlank
    @NotNull
    private String name;

    @NotBlank
    @NotNull
    private LocalDateTime accountCreationDate;

}
