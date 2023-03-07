package com.studentmanagement.studentmanagementsys.service;

import com.studentmanagement.studentmanagementsys.entity.Student;

import java.util.List;

public interface StudentService {

    List<Student> getAll();
    Student register(Student student);
    Student getById(Long id);
    Student update(Student student, Long id);
    void delete(Long id);

}
