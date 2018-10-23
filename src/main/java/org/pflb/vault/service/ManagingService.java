package org.pflb.vault.service;

import org.pflb.vault.model.Course;
import org.pflb.vault.model.Mark;
import org.pflb.vault.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

@Service
public class ManagingService {

    @Autowired
    private StudentCache storage;

    @Autowired
    private CourseCache courseCache;

    private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");

    public Student createStudent(String name, String phone, String email) {
        Student student = new Student();
        student.setPhoneNumber(phone);
        student.setName(name);
        student.setEmail(email);
        return student;
    }

    public Course createCourse(String name, String dateStart, String dateFinish) {
        Course course = new Course();
        course.setName(name);


        LocalDate dateS = LocalDate.parse(dateStart, formatter);
        LocalDate dateF = LocalDate.parse(dateFinish, formatter);

        course.setDateStart(dateS);
        course.setDateFinish(dateF);

        Long days = ChronoUnit.DAYS.between(dateS, dateF);
        course.setLengthCourse(days);
        return course;
    }


    public Mark createMark(Long studentId, Long courseId, int i, String date) {
        Mark mark = new Mark();
        mark.setCourseId(courseId);
        mark.setStudentId(studentId);
        mark.setMark(i);
        mark.setDate(LocalDate.parse(date, formatter));
        return mark;
    }

}