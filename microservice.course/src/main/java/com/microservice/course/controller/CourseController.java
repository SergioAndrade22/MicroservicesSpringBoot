package com.microservice.course.controller;

import com.microservice.course.entity.Course;
import com.microservice.course.service.ICourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/courses")
public class CourseController {
    @Autowired
    private ICourseService courseService;

    @PostMapping
    public ResponseEntity<?> save(@RequestBody Course course) {
        return new ResponseEntity<Course>(courseService.save(course), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable Long id) {
        return ResponseEntity.ok(courseService.findById(id));
    }

    @GetMapping()
    public ResponseEntity<?> getAll() {
        return ResponseEntity.ok(courseService.findAll());
    }

    @GetMapping("/{id}/students")
    public ResponseEntity<?> findAllStudentsByCourseId(@PathVariable Long id) {
        return ResponseEntity.ok(courseService.findAllStudentsByCourseId(id));
    }
}
