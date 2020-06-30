package com.sunjyot.home.challenge.grabcab.application.repository;

import com.sunjyot.home.challenge.grabcab.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public Boolean checkUserExistence(Long userId){
        if(jdbcTemplate.query(
                "SELECT * FROM USER WHERE ID = " + userId,
                (rs,rowNum)->
                        new User(
                                rs.getLong("ID"),
                                rs.getString("NAME"),
                                rs.getLong("PHONE"))).isEmpty())
            return false;
        else
            return true;
    }

    public int insert(User user){
        return jdbcTemplate.update("INSERT INTO USER (ID, NAME, PHONE) " + "values(?, ?, ?)",
                new Object[] {
                        user.getId(),
                        user.getName(),
                        user.getPhone()
                });
    }
}
