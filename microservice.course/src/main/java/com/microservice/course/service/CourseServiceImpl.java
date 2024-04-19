package com.microservice.course.service;

import com.microservice.course.clients.StudentClient;
import com.microservice.course.dto.StudentDTO;
import com.microservice.course.entity.Course;
import com.microservice.course.http.response.StudentByCourseResponse;
import com.microservice.course.repository.ICourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseServiceImpl implements ICourseService{
    @Autowired
    private ICourseRepository courseRepository;
    @Autowired
    private StudentClient studentClient;

    @Override
    public List<Course> findAll() {
        return (List<Course>) courseRepository.findAll();
    }

    @Override
    public Course findById(Long id) {
        return courseRepository.findById(id).orElseThrow();
    }

    @Override
    public Course save(Course course) {
        return courseRepository.save(course);
    }

    @Override
    public StudentByCourseResponse findAllStudentsByCourseId(Long courseId) {
        Course course = courseRepository.findById(courseId).orElse(new Course());

        List<StudentDTO> studentDTOList = studentClient.findAllStudentsByCourseId(courseId);

        return StudentByCourseResponse.builder()
                .courseName(course.getName())
                .teacher(course.getTeacher())
                .studentList(studentDTOList)
                .build();
    }
}
