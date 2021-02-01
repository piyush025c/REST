package dao;

import org.example.Student;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class StudentRowMapper implements RowMapper<Student> {

    @Override
    public Student mapRow(ResultSet resultSet, int i) throws SQLException {

        Student student=new Student();
        student.setRollNo(resultSet.getInt("rollno"));
        student.setName(resultSet.getString("name"));
        student.setAge(resultSet.getInt("age"));


        return student;
    }
}
