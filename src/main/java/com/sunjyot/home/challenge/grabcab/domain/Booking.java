package com.sunjyot.home.challenge.grabcab.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Getter
@Setter
@AllArgsConstructor
public class Booking {

    @Id
    @GeneratedValue
    private Long id;

    private Long userId;
    private Long cabId;

    private Long fromXAxis;
    private Long fromYAxis;
    private Long toXAxis;
    private Long toYAxis;

    private Timestamp timestamp;
    
}
