package org.example.controller;


import org.example.dao.DrugOfMonthDao;
import org.example.model.DrugOfMonthDetails;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("drugOfMonth")
public class DrugOfMonthController {

    static ApplicationContext context=new ClassPathXmlApplicationContext("config.xml");
    DrugOfMonthDao drugOfMonthDao=context.getBean("drugOfMonthDao",DrugOfMonthDao.class);

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<DrugOfMonthDetails> getDrugOfMonth(@QueryParam("city") String city)
    {

        return drugOfMonthDao.getDrugOfMonth(city);
    }
}
