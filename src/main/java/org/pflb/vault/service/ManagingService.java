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
storage.saveStudent(student);
        return student;
    }

    public Course createCourse(String name, String dateStart, String dateFinish) {
        Course course = new Course();
        course.setName(name);

     //   SimpleDateFormat format = new SimpleDateFormat();

        LocalDate dateS = null;
        LocalDate dateF = null;

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");

        try {
            dateS = LocalDate.parse(dateStart, formatter);
            dateF = LocalDate.parse(dateFinish, formatter);
        } catch (Exception e) {
            e.printStackTrace();
        }

        course.setDateStart(dateS);
        course.setDateFinish(dateF);


//        // Количество дней между датами в миллисекундах
//        long difference = dateF.getTime() - dateS.getTime();
//        // Перевод количества дней между датами из миллисекунд в дни
//        long days = (int) (difference / (24 * 60 * 60 * 1000)); // миллисекунды / (24ч * 60мин * 60сек * 1000мс)

 //       course.setLengthCourse(days);
        //course.setListStudents();
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
