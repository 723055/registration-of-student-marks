package org.pflb.vault.service;

import org.pflb.vault.model.Course;
import org.pflb.vault.model.Student;

import java.util.List;

public interface StudentCache {

    void saveStudent(Student student);

    Student getStudentById(Long id);

    void deleteStudentById(Long id);

 //  List<Student> getAllCoursesByStudent(String course);



}
