package com.sunjyot.home.challenge.grabcab.application.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class PositionDTO {

    private Long userId;
    private Long fromXAxis;
    private Long fromYAxis;
    private Long toXAxis;
    private Long toYAxis;

}
