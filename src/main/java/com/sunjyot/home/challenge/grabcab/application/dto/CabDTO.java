package com.sunjyot.home.challenge.grabcab.application.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.lang.NonNull;

@Getter
@Setter
@AllArgsConstructor
public class CabDTO {

    @NonNull
    private Long XAxis;

    @NonNull
    private Long YAxis;

}
