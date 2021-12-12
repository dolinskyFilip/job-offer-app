package com.digitalnewagency.jobofferapp.model.repository;

import com.digitalnewagency.jobofferapp.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,String> {
}
