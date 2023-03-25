package com.driver;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class StudentRepository {

    HashMap<String, Student> studentDB = new HashMap<>();
    HashMap<String, Teacher> teacherDB = new HashMap<>();
    HashMap<String, String> studentTeacherPairDB = new HashMap<>();

    public String addStudent(Student student)
    {
        String key = student.getName();
        studentDB.put(key,student);
        return "New student added successfully";
    }

    public String addTeacher(Teacher teacher)
    {
        String key = teacher.getName();
        teacherDB.put(key,teacher);
        return "New teacher added successfully";
    }

    public String addStudentTeacherPair(String studentName, String teacherName)
    {
        studentTeacherPairDB.put(studentName, teacherName);
       return "New student-teacher pair added successfully";
    }

    public Student getStudentByName(String studentName)
    {
        Student student = studentDB.get(studentName);
        return student;
    }
    public Teacher getTeacherByName(String teacherName)
    {
        Teacher teacher = teacherDB.get(teacherName);
        return teacher;
    }

    public List<String> getStudentsByTeacherName(String teacherName)
    {
        List<String> allStudent = new ArrayList<>();

        for(Map.Entry<String,String> entry : studentTeacherPairDB.entrySet())
        {
            if(entry.getValue().equals(teacherName))
            {
                allStudent.add(entry.getKey());
            }
        }
        return allStudent;
    }

    public List<String> getAllStudents(){
        List<String> allStudent = new ArrayList<>();

        for(String name : studentDB.keySet())
        {
            allStudent.add(name);
        }

        return allStudent;
    }

    public String deleteTeacherByName(String teacherName)
    {
        teacherDB.remove(teacherName);
        for(Map.Entry<String,String> entry : studentTeacherPairDB.entrySet())
        {
            if(entry.getValue().equals(teacherName))
            {
                String student = entry.getKey();
                studentDB.remove(student);
                studentTeacherPairDB.remove(student);
            }
        }
        return " removed successfully";
    }
    public String deleteAllTeachers()
    {
        for(String teacherName : teacherDB.keySet())
        {
            teacherDB.remove(teacherName);
            for(Map.Entry<String,String> entry : studentTeacherPairDB.entrySet())
            {
                if(entry.getValue().equals(teacherName))
                {
                    String student = entry.getKey();
                    studentDB.remove(student);
                    studentTeacherPairDB.remove(student);
                }
            }
        }

        return "All teachers deleted successfully";
    }
}
