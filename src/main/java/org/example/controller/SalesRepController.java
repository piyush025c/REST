package org.example.controller;

import org.example.dao.SalesRepDao;
import org.example.model.SalesRep;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("salesrep")
public class SalesRepController {

    static ApplicationContext context=new ClassPathXmlApplicationContext("config.xml");
    SalesRepDao salesRepDao=context.getBean("salesRepDao",SalesRepDao.class);

    @GET
    @Path("all")
    @Produces(MediaType.APPLICATION_JSON)
    public List<SalesRep> getAllSalesRep(@QueryParam("offset") int offset,@QueryParam("limit") int limit)
    {
        return salesRepDao.getAllSalesRep(offset,limit);
    }

    @POST
    @Path("add")
    @Consumes(MediaType.APPLICATION_JSON)
    public SalesRep addSalesRep(SalesRep salesRep)
    {

        salesRepDao.addSalesRep(salesRep);
        return salesRep;
    }

    @PUT
    @Path("update")
    @Consumes(MediaType.APPLICATION_JSON)
    public SalesRep updateSalesRep(SalesRep salesRep)
    {

        salesRepDao.updateSalesRep(salesRep);
        return salesRep;
    }

    @DELETE
    @Path("delete/{id}")
    public void deleteSalesRep(@PathParam("id") int salesRepId)
    {
        salesRepDao.deleteSalesRep(salesRepId);
    }
}
