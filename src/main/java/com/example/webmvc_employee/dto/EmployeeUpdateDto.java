package com.example.webmvc_employee.dto;

import com.example.webmvc_employee.entity.EmpType;
import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EmployeeUpdateDto {
  private String empId;
  private EmpType empType;
  private Long salary;
}