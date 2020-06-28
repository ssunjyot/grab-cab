package com.sunjyot.home.challenge.grabcab.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Getter
@Setter
public class Cab {

    @Id
    @GeneratedValue
    private Long id;

    private Boolean occupied;

    private Long XAxis;
    private Long YAxis;

    public Cab(long id, Boolean occupied, long XAxis,long YAxis) {
        this.id = id;
        this.occupied = occupied;
        this.XAxis = XAxis;
        this.YAxis = YAxis;
    }
}
