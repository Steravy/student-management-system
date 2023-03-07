package com.studentmanagement.studentmanagementsys.service.Impl;

import com.studentmanagement.studentmanagementsys.entity.Student;
import com.studentmanagement.studentmanagementsys.exceptions.ResourceNotFoundException;
import com.studentmanagement.studentmanagementsys.repository.StudentRepository;
import com.studentmanagement.studentmanagementsys.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;

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

    @Override
    public Student getById(Long id) {
        Optional<Student> student = this.studentRepository.findById(id);

        if (student.isPresent()) {
            return student.get();
        } else {
            throw new ResourceNotFoundException("Student", "Id", id);
        }
    }

    @Override
    public Student update(Student student, Long id) {
        Student studentToUpdate = this.getById(id);
        studentToUpdate.setFirstName(student.getFirstName());
        studentToUpdate.setLastName(student.getLastName());
        studentToUpdate.setEmail(student.getEmail());
        studentRepository.save(studentToUpdate);

        return null;
    }

    @Override
    public void delete(Long id) {
        studentRepository.deleteById(id);
    }
}
