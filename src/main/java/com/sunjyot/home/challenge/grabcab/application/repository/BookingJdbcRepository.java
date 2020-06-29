package com.sunjyot.home.challenge.grabcab.application.repository;

import com.sunjyot.home.challenge.grabcab.domain.Booking;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class BookingJdbcRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public int insert(Booking booking) {
        return jdbcTemplate.update("INSERT INTO BOOKING (ID, USER_ID, CAB_ID, FROMXAXIS, FROMYAXIS, TOXAXIS, TOYAXIS, TIMESTAMP) " + "values(?, ?, ?, ?, ?, ?, ?, ?)",
                new Object[] {
                        booking.getId(),
                        booking.getUserId(),
                        booking.getCabId(),
                        booking.getFromXAxis(),
                        booking.getFromYAxis(),
                        booking.getToXAxis(),
                        booking.getToYAxis(),
                        booking.getTimestamp()
                });
    }
}
