package org.example.dao;

import org.example.model.DrugOfMonthDetails;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class DrugOfMonthRowMapper implements RowMapper<DrugOfMonthDetails> {

    @Override
    public DrugOfMonthDetails mapRow(ResultSet rs, int i) throws SQLException {

        DrugOfMonthDetails drug=new DrugOfMonthDetails();
        drug.setProduct(rs.getString(1));
        drug.setTotalByCityForCurMonth(rs.getInt(2));

        return drug;
    }
}
