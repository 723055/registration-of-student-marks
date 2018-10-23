package org.pflb.vault.repository;

import org.pflb.vault.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {

    Student getStudentById(Long id);

    void deleteStudentById(Long id);

}
