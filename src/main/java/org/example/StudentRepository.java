package org.example;

import java.util.ArrayList;
import java.util.List;

public class StudentRepository {

    List<Student> studentList;

    StudentRepository()
    {
        studentList=new ArrayList<Student>();

        Student student1=new Student(5,"Piyush",22);
        Student student2=new Student(7,"Ram",23);

        studentList.add(student1);
        studentList.add(student2);
    }

    public List<Student> getStudentList()
    {
        return studentList;
    }


    public void addStudent(Student student) {

        studentList.add(student);
        System.out.println("Student added "+ studentList.size());

        /*if(studentList.size()==0)
            System.out.println("Something wrong");
        System.out.println(studentList.get(0).getName());*/
    }

    public void updateStudent(Student student)
    {
        Student temp=null;

        for(int i=0;i<studentList.size();i++)
            if(student.getRollNo()==studentList.get(i).getRollNo())
            {
                temp=studentList.get(i);
                break;
            }

        if(temp!=null)
        {
            temp.setName(student.getName());
            temp.setAge(student.getAge());

            System.out.println(student.getName()+ " "+studentList.get(0).getName());

        }
    }


    public Student deleteStudent(int index) {

        Student temp=null;

        if(index>=0&&index<studentList.size())
        {
            temp=studentList.get(index);
            studentList.remove(index);
            System.out.println("Student at "+index+" deleted.");
        }

        System.out.println(studentList.size());
        return temp;
    }
}
