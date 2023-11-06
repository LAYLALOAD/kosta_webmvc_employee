package com.example.webmvc_employee.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class EmployeeFamily {
  @Id
  @Column(name="family_id", length=6)
  private String familyId; // equals emp_id
  private String familyName;
  private String familyType;
}