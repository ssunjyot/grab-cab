package com.sunjyot.home.challenge.grabcab.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
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

    public Booking(Long id, Long userId, Long cabId, Long fromXAxis, Long fromYAxis, Long toXAxis, Long toYAxis) {
        this.id = id;
        this.userId = userId;
        this.cabId = cabId;
        this.fromXAxis = fromXAxis;
        this.fromYAxis = fromYAxis;
        this.toXAxis = toXAxis;
        this.toYAxis = toYAxis;
    }

    @Override
    public String toString(){
        return "You have successfully booked cab number : " + this.cabId;
    }
}
