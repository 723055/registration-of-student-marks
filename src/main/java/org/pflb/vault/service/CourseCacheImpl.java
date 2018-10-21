package org.pflb.vault.service;

import com.google.common.collect.Maps;
import org.pflb.vault.model.Course;
import org.pflb.vault.model.Student;
import org.pflb.vault.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;


@Service("persistent_course")
public class CourseCacheImpl implements CourseCache {


    @Autowired
    CourseRepository courseRepository;



    @Override
    public void saveCourse(Course course) {

        courseRepository.save(course);
    }

//    @Override
//    public Course getCourseById(Long id) {
//
//        return courseRepository.getCourseById(id);
//    }



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




//    private Map<Long, Long> studentMap = Maps.newHashMap();
//    private Map<String,Student> courseMap = Maps.newHashMap();


//    @Override
//    public void addStudentOnCourse(Long courseId, Long studentId) {
//        studentMap.put(courseId, studentId);
//        courseRepository
//

//        Course course = courseRepository.
//        courseRepository.addStudentOnCourse(student);



}
