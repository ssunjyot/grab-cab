package com.sunjyot.home.challenge.grabcab.application.repository;

import com.sunjyot.home.challenge.grabcab.domain.Cab;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CabJdbcRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Cab> getAvailableCabs(){
        return jdbcTemplate.query(
                "SELECT * FROM CAB WHERE OCCUPIED = FALSE",
                (rs,rowNum) ->
                        new Cab(
                                rs.getLong("ID"),
                                rs.getBoolean("OCCUPIED"),
                                rs.getLong("XAXIS"),
                                rs.getLong("YAXIS")
                        )
        );
    }

    public int update(Cab cab) {
        return jdbcTemplate.update("UPDATE CAB " + " SET OCCUPIED = ?, XAXIS = ? " + ", YAXIS = ?" + " WHERE ID = ?",
                new Object[] {
                        cab.getOccupied(),
                        cab.getXAxis(),
                        cab.getYAxis(),
                        cab.getId()
                });
    }

    public int insert(Cab cab){
        return jdbcTemplate.update("INSERT INTO CAB (ID, OCCUPIED, XAXIS, YAXIS) " + "VALUES(?, ?, ?, ?)",
                new Object[] {
                        cab.getId(),
                        cab.getOccupied(),
                        cab.getXAxis(),
                        cab.getYAxis()
                });
    }
}