package com.example.webmvc_employee.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Department {
  @Id
  @GeneratedValue(strategy= GenerationType.IDENTITY)
  private int deptId;
  @Column(name="dept_name" , length=10)
  private String deptName;
}