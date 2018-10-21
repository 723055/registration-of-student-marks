package org.pflb.vault.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@ToString
@EqualsAndHashCode
@Getter
@Setter
@Entity
@Table(name = "COURSE")
public class Course implements Serializable {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "dateStart")
    private LocalDate dateStart;

    @Column(name = "dateFinish")
    private LocalDate dateFinish;

    @Column(name = "lengthCourse")
    private Long lengthCourse;

//    @Column(name = "listStudents")
//    private String listStudents;


    @ManyToMany(cascade = {CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinTable(name = "student_course", joinColumns = @JoinColumn(name = "course_id"),
            inverseJoinColumns = @JoinColumn(name = "student_id"))
  //  @JsonIgnore
    private List<Student> students = new ArrayList<>();


}
