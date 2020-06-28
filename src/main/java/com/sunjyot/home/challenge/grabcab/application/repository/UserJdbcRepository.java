package com.sunjyot.home.challenge.grabcab.application.repository;

import com.sunjyot.home.challenge.grabcab.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class UserJdbcRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public int insert(User user){
        return jdbcTemplate.update("INSERT INTO USER (ID, NAME, PHONE) " + "values(?, ?, ?)",
                new Object[] {
                        user.getId(),
                        user.getName(),
                        user.getPhone()
                });
    }
}
