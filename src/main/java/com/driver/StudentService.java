package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class StudentService {
    @Autowired
    StudentRepository studentRepository;

    public void addStudent(Student student)
    {
        studentRepository.addStudent(student);

    }

    public void addTeacher(@RequestBody Teacher teacher)
    {
        studentRepository.addTeacher(teacher);

    }

    public void addStudentTeacherPair(String studentName, String teacherName)
    {
        studentRepository.addStudentTeacherPair(studentName, teacherName);
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

    public void deleteTeacherByName(String teacherName)
    {
        studentRepository.deleteTeacherByName(teacherName);

    }
    public void deleteAllTeachers()
    {
        studentRepository.deleteAllTeachers();
    }
}

