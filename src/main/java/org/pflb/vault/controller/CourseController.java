package org.pflb.vault.controller;


import org.pflb.vault.model.Course;
import org.pflb.vault.model.Mark;
import org.pflb.vault.model.Student;
import org.pflb.vault.service.CourseCache;
import org.pflb.vault.service.ManagingService;
import org.pflb.vault.service.MarkCache;
import org.pflb.vault.service.StudentCache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/")
public class CourseController {

    //@Qualifier("persistent_course")

    @Autowired
    private CourseCache storageCourse;

    @Autowired
    private StudentCache studentCache;


    @Autowired
    private ManagingService coursesManagingService;

    @Autowired
    private MarkCache markCache;


    @GetMapping("courses/{name}/{dateStart}/{dateFinish}")
    public String createCourse(@PathVariable String name, @PathVariable String dateStart, @PathVariable String dateFinish) {
        Course course = coursesManagingService.createCourse(name, dateStart, dateFinish);
        storageCourse.saveCourse(course);
        return "Мы создали, " + course.toString();
    }

    @DeleteMapping(value = "/courses/{id}")
    public void deleteCourse(@PathVariable Long id) {
        storageCourse.deleteCourseById(id);

    }

    @GetMapping("courses/course_list")
    public List<Course> courseList() {

        return storageCourse.getAllCourses();
    }

    @GetMapping("courses/get/{id}")
    public Course getCourseById(@PathVariable Long id) {
        Course course = storageCourse.getCourseById(id);

        for (Student student : course.getStudents()) {
            List<Mark> marks = markCache.getMarkByStudentIdAndCourseId(student.getId(), id);
            student.getMarks().addAll(marks);
        }
        return course;
    }

    @GetMapping("courses/{courseId}/add/{studentId}")
    public String attachStudentToCourse(@PathVariable Long courseId, @PathVariable Long studentId) {
        Course course = storageCourse.getCourseById(courseId);
        Student student = studentCache.getStudentById(studentId);
        course.getStudents().add(student);
        storageCourse.saveCourse(course);
        return "Студент добавлен к курсу";
    }

    @DeleteMapping("courses/{courseId}/delete/{studentId}")
    public String deleteStudentToCourse(@PathVariable Long courseId, @PathVariable Long studentId) {
        Course course = storageCourse.getCourseById(courseId);
        Student student = studentCache.getStudentById(studentId);
        course.getStudents().remove(student);
        storageCourse.saveCourse(course);
        return "Студент удален из курса";
    }
