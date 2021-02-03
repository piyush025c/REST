package org.example.handler;

import org.example.dao.RepOfMonthDao;
import org.example.dao.RepOfMonthRowMapper;
import org.example.model.RepOfMonthDetails;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class RepOfMonthHandler implements RepOfMonthDao {

    JdbcTemplate template;

    public JdbcTemplate getTemplate() {
        return template;
    }

    public void setTemplate(JdbcTemplate template) {
        this.template = template;
    }

    @Override
    public List<RepOfMonthDetails> getSalesRepOfMonth(int month, String product) {

        String sql="select hd.sales_rep_id,sales_rep_name, SUM(price) AS total from sales_rep, historical_data hd " +
                "where EXTRACT(MONTH FROM date)=? and product=?  " +
                "and sales_rep.sales_rep_id=hd.sales_rep_id group by hd.sales_rep_id,sales_rep_name " +
                "ORDER BY total DESC LIMIT 3";

        RepOfMonthRowMapper rowMapper=new RepOfMonthRowMapper();

        return template.query(sql,rowMapper,month,product);
    }
}
