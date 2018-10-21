package org.pflb.vault.service;

import org.pflb.vault.model.Course;
import org.pflb.vault.model.Student;

import java.util.List;

public interface CourseCache {
    void saveCourse(Course course);

   // Course getCourseByName(Long id);

    void deleteCourseById(Long id);

    List<Course> getAllCourses();

    Course getCourseById(Long id);

 //   List<Course> getCoursesByStudentId(Long studentId);

//    void addStudentOnCourse (Long courseId, Long studentId);

}
