package org.pflb.vault.service;

import org.pflb.vault.model.Course;
import org.pflb.vault.model.Student;
import org.pflb.vault.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("persistent")
public class StudentCacheImpl implements StudentCache {

    @Autowired
    StudentRepository studentRepository;


    @Override
    public void saveStudent(Student student) {

        studentRepository.save(student);
    }


    @Override
    public Student getStudentById(Long id) {

        return studentRepository.getStudentById(id);
    }

//
//    @Override
//    public List<Student> getAllCoursesByStudent(String name) {
//
//        return studentRepository.getAllStudentsByCourse(name);
//    }

}
