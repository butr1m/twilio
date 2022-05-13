package com.example.twilio.repository;

import com.example.twilio.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

    User findByPhoneNumber(String phoneNumber);
}
