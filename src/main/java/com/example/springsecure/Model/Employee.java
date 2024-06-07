package com.example.springsecure.Model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import java.util.List;


@Entity
@Table(name = "Employee_3")
@Getter
@Setter
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    private Post post;

    @ElementCollection()
    @CollectionTable(name = "employee_skills", joinColumns = @JoinColumn(name = "employee_id"))
    @Column(name = "skill")
    @Fetch(value = FetchMode.JOIN) // Eager fetch
    private List<String> skills;

    @ManyToMany(mappedBy = "employees",fetch=FetchType.EAGER)
    private List<Project> projects;

}
