package dao;

import org.example.Student;

import java.util.List;

public interface StudentDao {

    public void addStudent(Student student);
    public void updateStudent(Student student);
    public void deleteStudent(int rollNo);
    public List<Student> getStudentList();
}
