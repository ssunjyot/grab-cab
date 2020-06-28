package com.sunjyot.home.challenge.grabcab.application;

import com.sunjyot.home.challenge.grabcab.application.dto.UserDTO;
import com.sunjyot.home.challenge.grabcab.application.repository.UserJdbcRepository;
import com.sunjyot.home.challenge.grabcab.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class RegistrationService {

    @Autowired
    private UserJdbcRepository userJdbcRepository;

    public User createUser(UserDTO userDTO) {
        User user = new User(Math.abs(new Random().nextLong()), userDTO.getName(), userDTO.getPhone());

        userJdbcRepository.insert(user);
        return user;
    }
}
