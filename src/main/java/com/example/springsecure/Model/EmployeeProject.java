package com.example.springsecure.Model;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Entity
@Table(name = "Employee_Project")
@Getter
@Setter
public class EmployeeProject {
    @Id
    private Long id;
    @Column(name = "implication")
    private BigDecimal implication;

    @ManyToOne
    @JoinColumn(name = "employee_id", insertable = false, updatable = false)
    private Employee employee;


    @ManyToOne
    @JoinColumn(name = "project_id", insertable = false, updatable = false)
    private Project project;



    @Override
    public String toString() {
        return "EmployeeProject{" +
                "project=" + project.getName() +
                ", implication=" + implication +
                '}';
    }
}
