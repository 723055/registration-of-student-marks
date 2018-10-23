package org.pflb.vault.repository;

import org.pflb.vault.model.Mark;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MarkRepository extends JpaRepository<Mark, Long> {
    List<Mark> getMarksByStudentIdAndCourseId(Long studentId, Long courseId);

}
