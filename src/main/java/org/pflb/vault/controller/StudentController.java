package org.pflb.vault.controller;

import org.pflb.vault.model.Course;
import org.pflb.vault.model.Mark;
import org.pflb.vault.model.Student;
import org.pflb.vault.service.CourseCache;
import org.pflb.vault.service.ManagingService;
import org.pflb.vault.service.MarkCache;
import org.pflb.vault.service.StudentCache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@RestController
@RequestMapping("/api/")
public class StudentController {

    //@Qualifier("persistent_student")
    @Autowired
    private StudentCache storageStudent;

    @Autowired
    private ManagingService managingService;

    @Autowired
    private CourseCache courseCache;

    @Autowired
    private MarkCache markCache;

    @GetMapping("students/{name}/{phone}/{email}")
    public String createStudent(@PathVariable String name, @PathVariable String phone, String email) {
        Student student = managingService.createStudent(name, phone, email);
        storageStudent.saveStudent(student);
        return "Привет, " + student.toString();
    }

   // @Secured({"ROLE_USER"})
    @GetMapping("students/student/{id}/{name}/{phone}")
    public void changeStudentData(@PathVariable Long id, @PathVariable String name, @PathVariable String phone, String email) {
        Student student = storageStudent.getStudentById(id);
        student.setName(name);
        student.setEmail(email);
        student.setPhoneNumber(phone);
        storageStudent.saveStudent(student);
    }

    @DeleteMapping(value = "/students/{id}")
    public void deleteStudent(@PathVariable Long id) {
        storageStudent.deleteStudentById(id);

    }

    @GetMapping("students/create")
    public String createData(){
        List<Course> courses = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Course course = new Course();
            course.setName("course-" + i);
            course.setDateStart(LocalDate.now().plusDays(i).minusDays(15));
            course.setDateFinish(LocalDate.now().plusDays(i + 10));
            courseCache.saveCourse(course);
            courses.add(course);
        }
        Random random = new Random();
        for (int i = 0; i < 20; i++) {
            Student student = new Student();
            student.setName("student-" + i);
            student.setEmail("email-" + i);
            student.setPhoneNumber("phone-" + i);
            Course course = courses.get(i % 10);
            student.getCourses().add(course);
            storageStudent.saveStudent(student);
            for (int j = 0; j < 10; j++) {
                LocalDate date = course.getDateStart().plusDays(j);
                Mark mark = new Mark();
                mark.setStudentId(student.getId());
                mark.setCourseId(course.getId());
                mark.setMark(random.nextInt(6));
                mark.setDate(date);
                markCache.saveMark(mark);
            }
        }
        return "saved!";
    }

}

