package org.pflb.vault.service;

import org.pflb.vault.model.Student;
import org.pflb.vault.repository.CourseRepository;
import org.pflb.vault.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("persistent")
public class StudentCacheImpl implements StudentCache {

    @Autowired
    StudentRepository studentRepository;

    @Autowired
    CourseRepository courseRepository;


    @Override
    public void saveStudent(Student student) {

        studentRepository.save(student);
    }

    @Override
    public Student getStudentById(Long id) {

        return studentRepository.getStudentById(id);
    }

    @Override
    public void deleteStudentById(Long id) {
        Student student = studentRepository.getStudentById(id);
        student.getCourses().clear();
        studentRepository.save(student);
        studentRepository.delete(student);
    }

    @Override
    public List<Student> getAllStudents() {

        return studentRepository.findAll();
    }

}
