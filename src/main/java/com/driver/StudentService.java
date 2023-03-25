package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class StudentService {
    @Autowired
    StudentRepository studentRepository;

    public String addStudent(Student student)
    {
        String add = studentRepository.addStudent(student);
        return add;
    }

    public String addTeacher(@RequestBody Teacher teacher)
    {
        String add = studentRepository.addTeacher(teacher);
        return add;
    }

    public String addStudentTeacherPair(String studentName, String teacherName)
    {
        String add = studentRepository.addStudentTeacherPair(studentName, teacherName);
        return add;
    }

    public Student getStudentByName(String studentName)
    {
        Student student = studentRepository.getStudentByName(studentName);
        return student;
    }
    public Teacher getTeacherByName(String teacherName)
    {
        Teacher teacher = studentRepository.getTeacherByName(teacherName);
        return teacher;
    }

    public List<String> getStudentsByTeacherName(String teacherName)
    {
        List<String> getAllStudents = studentRepository.getStudentsByTeacherName(teacherName);
        return getAllStudents;
    }

    public List<String> getAllStudents()
    {
        List<String> allStudents = studentRepository.getAllStudents();
        return allStudents;
    }

    public String deleteTeacherByName(String teacherName)
    {
        String delete = studentRepository.deleteTeacherByName(teacherName);
        return delete;
    }
    public String deleteAllTeachers()
    {
        String delete = studentRepository.deleteAllTeachers();
        return delete;
    }
}

