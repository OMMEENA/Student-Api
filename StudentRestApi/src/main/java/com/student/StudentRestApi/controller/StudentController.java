package com.student.StudentRestApi.controller;

import com.student.StudentRestApi.dao.RequestStudent;
import com.student.StudentRestApi.dto.Student;
import com.student.StudentRestApi.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(path = "/api/v1")
public class StudentController {

    @Autowired
    private IStudentService studentService;

    @PostMapping(value = "/student")
    public ResponseEntity<String> createStudent(@RequestBody RequestStudent requestBody) {
        studentService.createStudent(requestBody);
        return new ResponseEntity("student created", HttpStatus.CREATED);
    }

    @GetMapping(value = "/student")
    public ResponseEntity<List<Student>> studentList() {
        List<Student> response = studentService.studentList();

        return new ResponseEntity(response, HttpStatus.OK);
    }


    @GetMapping(value = "/student/{id}")
    public ResponseEntity<Student> getStudentById(@PathVariable int id) {
        Student response = studentService.getStudentById(id);
        return new ResponseEntity(response, HttpStatus.OK);

    }

    @DeleteMapping(value = "/student/{id}")
    public ResponseEntity<Student> deletStudentById(@PathVariable int id) {
        Student response = studentService.deleteStudentById(id);
        return new ResponseEntity(response, HttpStatus.OK);

    }

    @PutMapping(value = "/student/{id}")
    public ResponseEntity<Student> updateStudentById(@PathVariable int id , @RequestBody RequestStudent requestBody) {
        Student response = studentService.updateStudentById(id,requestBody);
        return new ResponseEntity(response, HttpStatus.OK);

    }

}