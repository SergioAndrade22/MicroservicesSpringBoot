package com.microservice.student.controller;

import com.microservice.student.entity.Student;
import com.microservice.student.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/students")
public class StudentController {
    @Autowired
    private IStudentService studentService;

    @PostMapping
    public ResponseEntity<?> saveStudent(@RequestBody Student student) {
        return new ResponseEntity<Student>(studentService.save(student), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable Long id) {
        return ResponseEntity.ok(studentService.findById(id));
    }

    @GetMapping
    public ResponseEntity<?> getAll() {
        return ResponseEntity.ok(studentService.findAll());
    }

    @GetMapping("/by-course-id/{courseId}")
    public ResponseEntity<?> findAllByCourseId(@PathVariable Long courseId) {
        return ResponseEntity.ok(studentService.findAllByCourseId(courseId));
    }
}
