package org.example.dao;

import org.example.model.SalesRep;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class SalesRepRowMapper implements RowMapper<SalesRep> {
    @Override
    public SalesRep mapRow(ResultSet rs, int i) throws SQLException {

        SalesRep salesRep=new SalesRep();

        salesRep.setSalesRepId(rs.getInt("sales_rep_id"));
        salesRep.setSalesRepName(rs.getString("sales_rep_name"));
        salesRep.setCountry(rs.getString("country"));
        salesRep.setCity(rs.getString("city"));
        salesRep.setPincode(rs.getInt("pincode"));
        salesRep.setGender(rs.getString("gender"));

        return salesRep;
    }
}
