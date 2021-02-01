package org.example;



import dao.StudentDao;
import dao.StudentRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.util.ArrayList;
import java.util.List;


public class StudentRepository implements StudentDao {

    JdbcTemplate template;

    public JdbcTemplate getTemplate() {
        return template;
    }

    public void setTemplate(JdbcTemplate template) {
        this.template = template;
    }

    @Override
    public List<Student> getStudentList()
    {
        List<Student> students = new ArrayList<>();
        String sql="select * from students";

        RowMapper<Student> rowMapper=new StudentRowMapper();
        return template.query(sql,rowMapper);

    }

    @Override
    public void addStudent(Student student) {

        String sql="insert into students values(?,?,?)";
        template.update(sql,student.getRollNo(),student.getName(),student.getAge());

        System.out.println("POST working..! ");

    }

    @Override
    public void updateStudent(Student student)
    {
        String sql="update students set name=? , age=? where rollno=?";
        int res=template.update(sql,student.getName(),student.getAge(),student.getRollNo());

        System.out.println("PUT working..! "+res+" rows affected");



    }

    @Override
    public void deleteStudent(int rollNo) {

        String sql="delete from students where rollno=?";

        int res=template.update(sql,rollNo);

        System.out.println("Delete working..! "+res+" rows affected");

    }
}
