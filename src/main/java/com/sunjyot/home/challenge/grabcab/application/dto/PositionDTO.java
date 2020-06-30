package com.sunjyot.home.challenge.grabcab.application.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.lang.NonNull;

@Getter
@Setter
@AllArgsConstructor
public class PositionDTO {

    @NonNull
    private Long userId;

    @NonNull
    private Long fromXAxis;

    @NonNull
    private Long fromYAxis;

    @NonNull
    private Long toXAxis;

    @NonNull
    private Long toYAxis;

}
