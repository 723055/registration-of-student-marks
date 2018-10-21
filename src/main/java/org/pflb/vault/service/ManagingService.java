package org.pflb.vault.service;

import org.pflb.vault.model.Course;
import org.pflb.vault.model.Mark;
import org.pflb.vault.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import javax.persistence.GeneratedValue;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.List;

@Service
public class ManagingService {

    @Autowired
    private StudentCache storage;

    @Autowired
    private CourseCache courseCache;


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

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");

        LocalDate dateS = LocalDate.parse(dateStart, formatter);
        LocalDate dateF = LocalDate.parse(dateFinish, formatter);

//        try {
//            dateS = LocalDate.parse(dateStart, formatter);
//            dateF = LocalDate.parse(dateFinish, formatter);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }

        course.setDateStart(dateS);
        course.setDateFinish(dateF);

        Long days = ChronoUnit.DAYS.between(dateS, dateF);
        course.setLengthCourse(days);
        return course;
    }





    public Mark createMark(Long studentId, Long courseId, int i) {
        Mark mark = new Mark();
        mark.setCourseId(courseId);
        mark.setStudentId(studentId);
        mark.setMark(i);
        return mark;
    }


//    public List <Course> findAllStudents(){
//
//    }

}

//        SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy");
//        Date date_start = new Date();
//        Date date_finish = new Date();
//
//        try {
//            date_start = format.parse(dateStart);
//            date_finish = format.parse(dateFinish);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//        // Количество дней между датами в миллисекундах
//        int difference = (int) (date_finish.getTime() - date_start.getTime());
//    //     Перевод количества дней между датами из миллисекунд в дни
//        int days = (difference / (24 * 60 * 60 * 1000)); // миллисекунды / (24ч * 60мин * 60сек * 1000мс)
