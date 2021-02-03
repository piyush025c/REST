package org.example.controller;

import org.example.dao.RepOfMonthDao;
import org.example.model.RepOfMonthDetails;
import org.example.model.SalesRep;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("repOfMonth")
public class RepOfMonthController {

    static ApplicationContext context=new ClassPathXmlApplicationContext("config.xml");
    RepOfMonthDao repOfMonthDao=context.getBean("repOfMonthDao",RepOfMonthDao.class);

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<RepOfMonthDetails> getSalesRepOfMonth(@QueryParam("month") int month,@QueryParam("product") String product)
    {
        return repOfMonthDao.getSalesRepOfMonth(month,product);
    }
}
