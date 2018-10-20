package org.pflb.vault.controller;


import org.pflb.vault.model.Course;
import org.pflb.vault.model.Mark;
import org.pflb.vault.model.Student;
import org.pflb.vault.repository.StudentRepository;
import org.pflb.vault.service.CourseCache;
import org.pflb.vault.service.ManagingService;
import org.pflb.vault.service.MarkCache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.security.PublicKey;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/")
public class CourseController {

    @Qualifier("persistent_course")

    @Autowired
    private CourseCache storageCourse;


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

    @DeleteMapping(value = "/courses/{name}")
    public void deleteCourse(@PathVariable String name) {
        storageCourse.deleteCourseByName(name);

    }

    @GetMapping("courses/course_list")
    public List<Course> courseList (){
        return storageCourse.getAllCourses();
    }

    @GetMapping("courses/get/{id}")
    public Course getCourseById(@PathVariable Long id){
        Course course = storageCourse.getCourseById(id);

        for (Student student:course.getStudents()){
            List<Mark> marks = markCache.getMarkByStudentId(student.getId());
            student.getMarks().addAll(marks);
        }
        return course;
    }


//    @PutMapping(value = "courses/course/{course}")
//    public String addStudentOnCourse(Student student, @PathVariable Course course){
//
//
//
//        List<Student> list = new ArrayList<>();
//        list.add(student);
//        course.setListStudents(list);
//        return "Мы добавили " + course.getListStudents().toString();
//
//    }


//    @Autowired
//    private StudentRepository studentRepository;
//
//    @GetMapping ("courses/course/{name_course}")
//    public Object[] getAllStudent(@PathVariable String name_course){
//        List<Student> students = studentRepository.getAllStudentsByCourse(name_course);
//        List<Student> list = new ArrayList<>();
//        for (Student student:students){
//            list.add(student);
//        }
//
//        return list.toArray();
//    }

//
//    @GetMapping
//    public void addStudentToCourse (String name, )
//


//
//    @GetMapping ()
//    public Student addStudentToCourse(String name){
//
//    }


//    @Secured({"ROLE_COMMON_COURsE"})
//    @GetMapping("courses/get_course/{name}")
//    public Course getCourse(@PathVariable String name) {
//        return storageCourse.getCourseByName(name);
//    }

}
