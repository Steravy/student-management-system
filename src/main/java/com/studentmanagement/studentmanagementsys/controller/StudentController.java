package com.studentmanagement.studentmanagementsys.controller;


import com.studentmanagement.studentmanagementsys.entity.Student;
import com.studentmanagement.studentmanagementsys.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/students")
public class StudentController {
    private final StudentService studentService;


    public StudentController(StudentService studentService) {
        super();
        this.studentService = studentService;
    }

    @GetMapping
    public String listStudents(Model model) {
        model.addAttribute("students", studentService.getAll());
        return "students";
    }

    @GetMapping("/new")
    public String createStudentForm(Model model) {

        // create student object to hold student form data
        Student student = new Student();
        model.addAttribute("student", student);
        return  "create_student";
    }

    @PostMapping
    public String register(@ModelAttribute("student") Student student) {
        studentService.register(student);
        return "redirect:/students";
    }

    @GetMapping("/edit/{id}")
    public String editStudentForm(@PathVariable Long id, Model model) {
        model.addAttribute("student", studentService.getById(id));
        return "edit_student";

    }

    @PostMapping("/{id}")
    public String update(@PathVariable Long id, @ModelAttribute("student") Student student, Model model) {
        studentService.update(student, id);
        return "redirect:/students";

    }

    @GetMapping("/{id}")
    public String delete(@PathVariable Long id) {
        studentService.delete(id);
        return "redirect:/students";
    }


}
