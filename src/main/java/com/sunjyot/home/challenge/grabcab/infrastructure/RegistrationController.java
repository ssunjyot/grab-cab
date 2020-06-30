package com.sunjyot.home.challenge.grabcab.infrastructure;

import com.sunjyot.home.challenge.grabcab.application.RegistrationService;
import com.sunjyot.home.challenge.grabcab.application.dto.CabDTO;
import com.sunjyot.home.challenge.grabcab.application.dto.UserDTO;
import com.sunjyot.home.challenge.grabcab.domain.Cab;
import com.sunjyot.home.challenge.grabcab.domain.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api(description = "API endpoints for creating new Users and registering new Cabs")
public class RegistrationController {

    @Autowired
    private RegistrationService registrationService;

    @ApiOperation(value = "Create a new user with supplied Name and Phone")
    @RequestMapping(path = "/user", method = RequestMethod.POST)
    public ResponseEntity createUser(@Validated @RequestBody UserDTO userDTO){
        User user = registrationService.createUser(userDTO);
        return ResponseEntity.ok("User created successfully with ID : " + user.getId());
    }

    @ApiOperation(value = "Register a new cab that is present at the given position(Represented as X and Y co-ordinates)")
    @RequestMapping(path = "/cab", method = RequestMethod.POST)
    public ResponseEntity createCab(@Validated @RequestBody CabDTO cabDTO){
        Cab cab = registrationService.createCab(cabDTO);
        return ResponseEntity.ok("Cab registered successfully with ID : " + cab.getId());
    }

}
