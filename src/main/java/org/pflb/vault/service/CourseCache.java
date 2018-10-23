package org.pflb.vault.service;

import org.pflb.vault.model.Course;

import java.util.List;

public interface CourseCache {
    void saveCourse(Course course);

    void deleteCourseById(Long id);

    List<Course> getAllCourses();

    Course getCourseById(Long id);

}
