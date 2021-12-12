package com.digitalnewagency.jobofferapp.model.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@Entity
public class User implements Serializable {

    @Id
    private String login;

    private String password;

    private String name;

    @Column(name="creation_date")
    private LocalDateTime accountCreationDate;

}
