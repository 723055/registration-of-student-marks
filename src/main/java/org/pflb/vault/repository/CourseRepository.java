package org.pflb.vault.repository;

import org.pflb.vault.model.Course;
import org.pflb.vault.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course, Long> {
    Course getCourseById(Long id);

  //  void addStudentOnCourse(Long courseId, Long studentId);


}
