package com.sunjyot.home.challenge.grabcab.infrastructure;

import com.sunjyot.home.challenge.grabcab.application.RegistrationService;
import com.sunjyot.home.challenge.grabcab.application.dto.UserDTO;
import com.sunjyot.home.challenge.grabcab.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RegistrationController {

    @Autowired
    private RegistrationService registrationService;

    @RequestMapping(path = "/user", method = RequestMethod.POST)
    public ResponseEntity createUser(@RequestBody UserDTO userDTO){
        User user = registrationService.createUser(userDTO);
        return ResponseEntity.ok("User created successfully with ID : " + user.getId());
    }

}
