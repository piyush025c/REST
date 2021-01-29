package org.example;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("students")
public class StudentResource {

    static StudentRepository repo=new StudentRepository();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Student> getStudent()
    {
        System.out.println("Workings lalala2..");
        return repo.getStudentList();
    }

    @POST
    @Path("student")
    @Consumes(MediaType.APPLICATION_JSON)
    public Student addStudent(Student student)
    {
        repo.addStudent(student);
        return student;
    }

    @PUT
    @Path("student")
    @Consumes(MediaType.APPLICATION_JSON)
    public Student updateStudent(Student student)
    {

         repo.updateStudent(student);
         return student;
    }

    @DELETE
    @Path("student/{index}")
    public Student deleteStudent(@PathParam("index") int index)
    {
         return repo.deleteStudent(index);
    }
}
