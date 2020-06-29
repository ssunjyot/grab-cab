package com.sunjyot.home.challenge.grabcab.application;

import com.sunjyot.home.challenge.grabcab.application.dto.CabDTO;
import com.sunjyot.home.challenge.grabcab.application.dto.UserDTO;
import com.sunjyot.home.challenge.grabcab.application.repository.CabRepository;
import com.sunjyot.home.challenge.grabcab.application.repository.UserRepository;
import com.sunjyot.home.challenge.grabcab.domain.Cab;
import com.sunjyot.home.challenge.grabcab.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class RegistrationService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CabRepository cabRepository;

    public User createUser(UserDTO userDTO) {
        User user = new User(Math.abs(new Random().nextLong()), userDTO.getName(), userDTO.getPhone());

        userRepository.insert(user);
        return user;
    }

    public Cab createCab(CabDTO cabDTO){
        Boolean occupied = false;
        Cab cab = new Cab(Math.abs(new Random().nextLong()), occupied, cabDTO.getXAxis(), cabDTO.getYAxis());

        cabRepository.insert(cab);
        return cab;
    }
}
