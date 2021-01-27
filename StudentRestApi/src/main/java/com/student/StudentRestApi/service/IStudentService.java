package com.student.StudentRestApi.service;

import com.student.StudentRestApi.dao.RequestStudent;
import com.student.StudentRestApi.dto.Student;

import java.util.List;

public interface IStudentService {

    String createStudent(RequestStudent requestStudent);
    List<Student> studentList();

    Student getStudentById(int id);

    Student deleteStudentById(int id);

    Student updateStudentById(int id ,RequestStudent requestStudent);

}

