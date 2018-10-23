package org.pflb.vault.repository;

import org.pflb.vault.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course, Long> {
    Course getCourseById(Long id);

}
