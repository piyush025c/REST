package org.example;

import java.util.ArrayList;
import java.util.List;
import java.sql.*;

public class StudentRepository {


    Connection con=null;

    StudentRepository()
    {

        String url="jdbc:postgresql://localhost:5432/demoDB";
        String username="postgres";
        String password="root";

        try {
            Class.forName("org.postgresql.Driver");
            con=DriverManager.getConnection(url,username,password);

            if(con!=null)
            System.out.println("Database connection established.");

        } catch (Exception e) {
            System.out.println("Connection problem "+e);
        }
    }

    public List<Student> getStudentList()
    {
        List<Student> students = new ArrayList<>();
        String sql="select * from students";

        try {
            Statement st = con.createStatement();
            ResultSet rs=st.executeQuery(sql);

            while(rs.next())
            {
                Student student=new Student(rs.getInt(1),rs.getString(2),rs.getInt(3));
                students.add(student);
            }

            System.out.println("GET working..!");
        }
        catch (Exception e)
        {
            System.out.println("Something Wrong: "+e);
        }
        return students;
    }


    public void addStudent(Student student) {

        String sql="insert into students values(?,?,?)";

        try{
            PreparedStatement st= con.prepareStatement(sql);

            st.setInt(1,student.getRollNo());
            st.setString(2,student.getName());
            st.setInt(3,student.getAge());

            int res=st.executeUpdate();
            System.out.println("POST working..!");
        }
        catch (Exception e)
        {
            System.out.println("Something Wrong: "+e);
        }

    }

    public void updateStudent(Student student)
    {
        String sql="update students set name=? , age=? where rollno=?";

        try{
            PreparedStatement st= con.prepareStatement(sql);

            st.setString(1,student.getName());
            st.setInt(2,student.getAge());
            st.setInt(3,student.getRollNo());

            int res=st.executeUpdate();
            System.out.println("PUT working..!");
        }
        catch (Exception e)
        {
            System.out.println("Something Wrong: "+e);
        }

    }


    public void deleteStudent(int rollNo) {

        String sql="delete from students where rollno=?";

        try{
            PreparedStatement st= con.prepareStatement(sql);

            st.setInt(1,rollNo);

            int res=st.executeUpdate();
            System.out.println("DELETE working..!");
        }
        catch (Exception e)
        {
            System.out.println("Something Wrong: "+e);
        }

    }
}
