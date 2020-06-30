package com.sunjyot.home.challenge.grabcab.application.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.lang.NonNull;

@Getter
@Setter
@AllArgsConstructor
public class UserDTO {

    @NonNull
    private String name;

    @NonNull
    private Long phone;

}
