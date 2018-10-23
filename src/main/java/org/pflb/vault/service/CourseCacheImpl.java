package org.pflb.vault.service;

import org.pflb.vault.model.Course;
import org.pflb.vault.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service("persistent_course")
public class CourseCacheImpl implements CourseCache {


    @Autowired
    CourseRepository courseRepository;


    @Override
    public void saveCourse(Course course) {

        courseRepository.save(course);
    }

    @Override
    public void deleteCourseById(Long id) {
        Course c = courseRepository.getCourseById(id);
        c.getStudents().clear();
        courseRepository.save(c);
        courseRepository.delete(c);
    }

    @Override
    public List<Course> getAllCourses() {
        return courseRepository.findAll();
    }

    @Override
    public Course getCourseById(Long id) {
        Course course = courseRepository.findById(id).get();
        return course;
    }

}
