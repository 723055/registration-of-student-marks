package org.pflb.vault.service;

import org.pflb.vault.model.Course;
import org.pflb.vault.model.Student;

import java.util.List;

public interface CourseCache {
    void saveCourse(Course course);

    Course getCourseByName(String name);

    void deleteCourseByName(String name);

    List<Course> getAllCourses();

    Course getCourseById(Long id);

//    void addStudentOnCourse (Long courseId, Long studentId);

}
