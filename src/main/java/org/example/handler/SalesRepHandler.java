package org.example.handler;

import org.example.dao.SalesRepDao;
import org.example.dao.SalesRepRowMapper;
import org.example.model.SalesRep;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class SalesRepHandler implements SalesRepDao {

    JdbcTemplate template;

    public JdbcTemplate getTemplate() {
        return template;
    }

    public void setTemplate(JdbcTemplate template) {
        this.template = template;
    }

    @Override
    public List<SalesRep> getAllSalesRep(int offset,int limit) {

        String sql="select * from sales_rep offset "+offset+" limit "+limit;
        System.out.println("GET Works..");

        SalesRepRowMapper rowMapper=new SalesRepRowMapper();
        return template.query(sql,rowMapper);


    }

    @Override
    public void addSalesRep(SalesRep salesRep) {

        String sql="insert into sales_rep(sales_rep_name, country, city, pincode, gender) values(?,?,?,?,?)";

        template.update(sql,salesRep.getSalesRepName(),salesRep.getCountry(),salesRep.getCity(),
                salesRep.getPincode(),salesRep.getGender());

        System.out.println("POST working..! ");

    }

    @Override
    public void updateSalesRep(SalesRep salesRep) {

        String sql="update sales_rep set sales_rep_name=? , country=? , city=? , pincode=? , gender=? where sales_rep_id=?";

        int rowsAffected=template.update(sql,salesRep.getSalesRepName(),salesRep.getCountry(),salesRep.getCity(),
                salesRep.getPincode(),salesRep.getGender(),salesRep.getSalesRepId());

        System.out.println("PUT working.., "+" "+rowsAffected+" row updated");

    }

    @Override
    public void deleteSalesRep(int salesRepId) {

        String sql="delete from sales_rep where sales_rep_id=?";
        int rowsAffected=template.update(sql,salesRepId);

        System.out.println("DELETE working.., "+" "+rowsAffected+" row deleted");

    }

    @Override
    public List<SalesRep> getSearchResult(String prefix, int offset, int limit) {

        String sql="select * from sales_rep where UPPER(sales_rep_name) LIKE UPPER('"+prefix+"%') OFFSET ? LIMIT ?";

        SalesRepRowMapper rowMapper=new SalesRepRowMapper();
        return template.query(sql,rowMapper,offset,limit);
    }
}
