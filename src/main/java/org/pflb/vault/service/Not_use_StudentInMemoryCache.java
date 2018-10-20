package org.pflb.vault.service;

import com.google.common.collect.Maps;
import org.pflb.vault.model.Course;
import org.pflb.vault.model.Student;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Map;

@Qualifier
@Service
public class Not_use_StudentInMemoryCache { //implements StudentCache, CourseCache {
//
//    private Map<String, Student> studentStorage = Maps.newHashMap();
//    private Map<String, Course> courseStorage = Maps.newHashMap();
//
//    public void saveStudent(Student student) {
//
//        studentStorage.put(student.getName(), student);
//    }
//
//    @Override
//    public void saveCourse(Course course) {
//
//        courseStorage.put(course.getName(), course);
//    }
//
//    public Student getStudentByName(String name) {
//
//        return studentStorage.get(name);
//    }
//
//    @Override
//    public Course getCourseByName(String name) {
//
//        return courseStorage.get(name);
//    }
//
//    @Override
//    public void deleteCourseByName(String name) {
//        courseStorage.remove(name);
//    }







//    @Override
//    public List<Student> getAllByRaceType(NotUse_RaceType notUseRaceType) {
//        return studentStorage.values()
//                .stream()
//                .filter(z -> z.getRace() == notUseRaceType)
//                .collect(Collectors.toList());
//    }
//
//    @Override
//    public List<Student> getAllByDamagePerSecondGreaterThan(Integer damagePerSecondLimit) {
//        return studentStorage.values()
//                .stream()
//                .filter(z -> z.getDamagePerSecond() > damagePerSecondLimit)
//                .collect(Collectors.toList());
//    }

//    @Override
//    public List<Student> getAllCreaturesHP(Integer hitPoints) {
//        return null;
//    }

}
