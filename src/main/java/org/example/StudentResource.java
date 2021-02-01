package org.example;

import dao.StudentDao;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("students")
public class StudentResource {


    static ApplicationContext context=new ClassPathXmlApplicationContext("config.xml");
    static StudentDao studentDao=context.getBean("studentDao",StudentDao.class);

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Student> getStudent()
    {
        System.out.println("GET called..");
        return studentDao.getStudentList();
    }

    @POST
    @Path("student")
    @Consumes(MediaType.APPLICATION_JSON)
    public Student addStudent(Student student)
    {
        studentDao.addStudent(student);
        return student;
    }

    @PUT
    @Path("student")
    @Consumes(MediaType.APPLICATION_JSON)
    public Student updateStudent(Student student)
    {

         studentDao.updateStudent(student);
         return student;
    }

    @DELETE
    @Path("student/{id}")
    public void deleteStudent(@PathParam("id") int id)
    {
          studentDao.deleteStudent(id);
    }
}
