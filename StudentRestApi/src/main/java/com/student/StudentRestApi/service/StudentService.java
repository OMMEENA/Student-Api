package com.student.StudentRestApi.service;

import com.student.StudentRestApi.dao.RequestStudent;
import com.student.StudentRestApi.dto.Student;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentService implements IStudentService {

    List<Student> list = new ArrayList<>();


    @Override
    public String createStudent(RequestStudent requestStudent) {
        list.add(new Student(requestStudent.getId(), requestStudent.getName(), requestStudent.getEmail(), requestStudent.getAge()));
        return null;
    }

    @Override
    public List<Student> studentList() {
        return list;
    }

    @Override
    public Student getStudentById(int id) {
        Student s = null;
        for (Student std : list) {
            if (std.getId() == id) {
                s = std;
            }
        }
        if (s != null) {
            return s;
        } else {
            throw new RuntimeException("Student not found");
        }
    }

    @Override
    public Student deleteStudentById(int id) {
        Student dt = null;
        for (Student std : list) {
            if (std.getId() == id) {
                dt = std;
                break;
            }
        }
        if (dt != null) {
            list.remove(dt);
            return dt;

        } else {
            throw new RuntimeException("Student not found");
        }


    }


    @Override
    public Student updateStudentById(int id,RequestStudent requestStudent) {
        int index = -1;
        for (Student std : list) {
            if (std.getId() == id) {
                index = list.indexOf(std);
                break;
            }
        }
        if (index != -1) {
            list.set(index,new Student(requestStudent.getId(),requestStudent.getName(),requestStudent.getEmail(),requestStudent.getAge()));
            return list.get(index);
        } else {
            throw new RuntimeException("Student not found");
        }

    }
}
