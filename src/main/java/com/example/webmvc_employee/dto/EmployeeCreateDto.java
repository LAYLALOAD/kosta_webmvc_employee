package com.example.webmvc_employee.dto;

import com.example.webmvc_employee.entity.EmpType;
import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EmployeeCreateDto {
  private String empId;
  private String empName;
  private EmpType empType;
  private String joinDate;
  private Long salary;
  private int deptId;
  private String familyName;
  private String familyType;
}