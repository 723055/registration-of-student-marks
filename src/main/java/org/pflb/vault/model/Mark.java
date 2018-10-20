package org.pflb.vault.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDate;


@ToString
@EqualsAndHashCode
@Getter
@Setter
@Entity
@Table(name = "MARK")
public class Mark {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @Column(name = "course_id")
    private Long courseId;

    @Column(name = "student_id")
    private Long studentId;

    @Column(name = "date")
    private LocalDate date;

    @Column(name = "mark")
    private int mark;


}
