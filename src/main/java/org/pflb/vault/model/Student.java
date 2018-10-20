package org.pflb.vault.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.ManyToAny;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@ToString
@EqualsAndHashCode
@Getter
@Setter
@Entity
@Table(name = "STUDENT")
public class Student implements Serializable {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "phone")
    private String phoneNumber;

    //@Enumerated
    @Column(name = "email")
    private String email;


    @ManyToMany(cascade = {CascadeType.ALL})
    @JoinTable(name = "student_course", joinColumns = @JoinColumn(name = "student_id"),
            inverseJoinColumns = @JoinColumn(name = "course_id"))
    @JsonIgnore
    private List<Course> courses = new ArrayList<>();

    @Transient
    private List<Mark> marks = new ArrayList<>();


}
