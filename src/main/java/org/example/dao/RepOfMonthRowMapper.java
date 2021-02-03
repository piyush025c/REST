package org.example.dao;

import org.example.model.RepOfMonthDetails;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class RepOfMonthRowMapper implements RowMapper<RepOfMonthDetails> {
    @Override
    public RepOfMonthDetails mapRow(ResultSet rs, int i) throws SQLException {

        RepOfMonthDetails rep=new RepOfMonthDetails();
        rep.setSalesRepId(rs.getInt(1));
        rep.setSalesRepName(rs.getString(2));
        rep.setMonthlyTotal(rs.getInt(3));

        return rep;
    }
}
