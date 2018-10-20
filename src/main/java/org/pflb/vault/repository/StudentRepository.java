package org.pflb.vault.repository;

import org.pflb.vault.model.Course;
import org.pflb.vault.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.ListResourceBundle;

public interface StudentRepository extends JpaRepository<Student, Long> {

    Student getStudentByName(String name);

//   List<Student> getAllStudentsByCourse(String course);

    //   Course getCourseByName(String name);

//
//    List<Student> getAllByDamagePerSecondGreaterThan(Integer damagePerSecondLimit);
//
//    List<Student> getAllByHitPointsGreaterThan(Integer hp);
//
// //   List<Student> getAllByRace(NotUse_RaceType notUseRaceType);
//
// //   List<Student> getAllBy<propertyName><GreaterThan/LesstThan/EqualTo>(<PropertyName>)
//
//    List<Student> getAllByHitPointsLessThan(Integer hitPoints);
}
