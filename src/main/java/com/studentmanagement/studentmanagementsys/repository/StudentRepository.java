package com.studentmanagement.studentmanagementsys.repository;

import com.studentmanagement.studentmanagementsys.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {

}
