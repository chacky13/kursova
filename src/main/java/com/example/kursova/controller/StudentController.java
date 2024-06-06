package com.example.kursova.controller;

import com.example.kursova.entity.Student;
import com.example.kursova.service.StudentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class StudentController {

    private StudentService studentService;

    public StudentController(StudentService studentService) {
        super();
        this.studentService = studentService;
    }

    // handler method to handle list students and return mode and view
    @GetMapping("/students")
    public String listStudents(Model model) {
        model.addAttribute("students", studentService.getAllStudents());
        model.addAttribute("sourcePage", "students");
        return "students";
    }

    @GetMapping("/show-stud")
    public String ShowStudlist(Model model) {
        model.addAttribute("students", studentService.getAllStudents());
        return "students";
    }

    @GetMapping("/students/new")
    public String createStudentForm(Model model) {

        // create student object to hold student form data
        Student student = new Student();
        model.addAttribute("student", student);
        return "create_student";

    }

    @PostMapping("/students")
    public String saveStudent(@ModelAttribute("student") Student student) {
        studentService.saveStudent(student);
        return "redirect:/students";
    }

    @GetMapping("/students/edit/{id}")
    public String editStudentForm(@PathVariable Long id, Model model) {
        model.addAttribute("student", studentService.getStudentById(id));
        return "edit_student";
    }

    @PostMapping("/students/{id}")
    public String updateStudent(@PathVariable Long id,
                                @ModelAttribute("student") Student student,
                                Model model) {

        // get student from database by id
        Student existingStudent = studentService.getStudentById(id);
        existingStudent.setId(id);
        existingStudent.setFirstName(student.getFirstName());
        existingStudent.setLastName(student.getLastName());
        existingStudent.setEmail(student.getEmail());

        // save updated student object
        studentService.updateStudent(existingStudent);
        return "redirect:/students";
    }

    // handler method to handle delete student request

    @GetMapping("/students/{id}")
    public String deleteStudent(@PathVariable Long id) {
        studentService.deleteStudentById(id);
        return "redirect:/students";
    }

    @GetMapping("/search/students")
    public String searchStudentsByLastName(@RequestParam(value = "lastName", required = false) String lastName, Model model) {
        List<Student> students = studentService.getStudentsByLastName(lastName);
        model.addAttribute("students", students);
        return "search-student";
    }

    @GetMapping("/search/stud-surname")
    public String searchStudentByLastName(@RequestParam(value = "lastName", required = false) String lastName, Model model) {
        List<Student> students = studentService.getStudentsByLastName(lastName);
        model.addAttribute("students", students);
        return "students";

    }


}
