package com.studentmanagement.studentmanagementsys.service.Impl;

import com.studentmanagement.studentmanagementsys.entity.Student;
import com.studentmanagement.studentmanagementsys.repository.StudentRepository;
import com.studentmanagement.studentmanagementsys.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    private StudentRepository studentRepository;

    @Autowired
    public StudentServiceImpl(StudentRepository studentRepository) {
        super();
        this.studentRepository = studentRepository;
    }

    @Override
    public List<Student> getAll() {
        return this.studentRepository.findAll();
    }

    @Override
    public Student register(Student student) {
        return studentRepository.save(student);
    }
}
