package com.microservice.course.clients;

import com.microservice.course.dto.StudentDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "msvc-student", url = "localhost:8080/api/students") // After configuring the Gateway Microservice it's possible to use that URL
public interface StudentClient {

    @GetMapping("/by-course-id/{courseId}")
    public List<StudentDTO> findAllStudentsByCourseId(@PathVariable Long courseId);
}
