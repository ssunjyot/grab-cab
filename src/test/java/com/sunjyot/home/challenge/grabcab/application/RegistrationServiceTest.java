package com.sunjyot.home.challenge.grabcab.application;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.sunjyot.home.challenge.grabcab.application.dto.CabDTO;
import com.sunjyot.home.challenge.grabcab.application.dto.UserDTO;
import com.sunjyot.home.challenge.grabcab.domain.Cab;
import com.sunjyot.home.challenge.grabcab.domain.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class RegistrationServiceTest {
    @Autowired
    private RegistrationService registrationService;

    @Test
    public void createUserTest(){
        UserDTO userDTO = new UserDTO("Name",9999999999L);

        User user = registrationService.createUser(userDTO);

        assertEquals(user.getName(), "Name");
        assertEquals(user.getPhone(),9999999999L);
    }

    @Test
    public void createCabTest(){
        CabDTO cabDTO = new CabDTO(1L,1L);

        Cab cab = registrationService.createCab(cabDTO);

        assertEquals(cab.getXAxis(),1L);
        assertEquals(cab.getYAxis(),1L);
    }
}
