package com.filmdome.webserver.repository;

import com.filmdome.webserver.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<User, Integer> {

    User findById(int id);

    User findByEmail(String email);

    User findByPhoneNumber(String phoneNumber);

    User findByUsername(String username);

    User findByPassword(String password);
}