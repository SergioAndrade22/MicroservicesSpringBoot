package com.microservice.student.service;

import com.microservice.student.entity.Student;
import com.microservice.student.repository.IStudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements IStudentService{

    @Autowired
    private IStudentRepository IStudentRepository;

    @Override
    public List<Student> findAll() {
        return (List<Student>) IStudentRepository.findAll();
    }

    @Override
    public Student findById(Long id) {
        return IStudentRepository.findById(id).orElseThrow();
    }

    @Override
    public Student save(Student student) {
        return IStudentRepository.save(student);
    }

    @Override
    public List<Student> findAllByCourseId(Long courseId) {
        return IStudentRepository.findAllByCourseId(courseId);
    }
}
