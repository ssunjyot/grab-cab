package com.sunjyot.home.challenge.grabcab.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Getter
@Setter
@AllArgsConstructor
public class Cab {

    @Id
    @GeneratedValue
    private Long id;

    private Boolean occupied;

    private Long XAxis;
    private Long YAxis;
}
