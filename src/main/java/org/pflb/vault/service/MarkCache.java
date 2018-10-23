package org.pflb.vault.service;

import org.pflb.vault.model.Mark;

import java.util.List;

public interface MarkCache {

    void saveMark(Mark mark);

    List<Mark> getMarkByStudentIdAndCourseId(Long studentId, Long courseId);
}
