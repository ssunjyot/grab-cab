package com.sunjyot.home.challenge.grabcab.application.repository;

import com.sunjyot.home.challenge.grabcab.domain.Booking;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BookingJdbcRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Booking> getUserBookingHistory(Long userId){
        String sqlQuery = "SELECT * FROM BOOKING WHERE USER_ID = " + userId + " ORDER BY TIMESTAMP";
        return jdbcTemplate.query(
                sqlQuery,
                (rs,rowNum) ->
                        new Booking(
                                rs.getLong("ID"),
                                rs.getLong("USER_ID"),
                                rs.getLong("CAB_ID"),
                                rs.getLong("FROMXAXIS"),
                                rs.getLong("FROMYAXIS"),
                                rs.getLong("TOXAXIS"),
                                rs.getLong("TOYAXIS"),
                                rs.getTimestamp("TIMESTAMP")
                        )
        );
    }

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
