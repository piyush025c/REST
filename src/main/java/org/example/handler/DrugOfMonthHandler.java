package org.example.handler;

import org.example.dao.DrugOfMonthDao;
import org.example.dao.DrugOfMonthRowMapper;
import org.example.model.DrugOfMonthDetails;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class DrugOfMonthHandler implements DrugOfMonthDao {

    JdbcTemplate template;

    public JdbcTemplate getTemplate() {
        return template;
    }

    public void setTemplate(JdbcTemplate template) {
        this.template = template;
    }

    @Override
    public List<DrugOfMonthDetails> getDrugOfMonth(String city) {

        String sql="select product, SUM(price) total from sales_rep sr, historical_data hd where " +
                "EXTRACT(MONTH FROM date)=EXTRACT(MONTH FROM CURRENT_DATE)" +
                " and city=? and sr.sales_rep_id=hd.sales_rep_id " +
                "GROUP BY product ORDER BY total DESC LIMIT 3";

        DrugOfMonthRowMapper rowMapper=new DrugOfMonthRowMapper();

        return template.query(sql,rowMapper,city);
    }
}
