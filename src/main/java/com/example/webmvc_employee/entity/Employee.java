package com.example.webmvc_employee.entity;

import com.example.webmvc_employee.dto.EmployeeCreateDto;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Employee {
  @Id
  @Column(name="emp_id", length=6)
  private String empId;
  @Column(name="emp_name", length=10)
  private String empName;
  @Enumerated(value = EnumType.STRING)
  @Column(name="emp_type", length=10)
  private EmpType empType;
  @Column(name="join_date", length=10)
  private String joinDate;
  private Long salary;

  @ManyToOne
  @JoinColumn(name="dept_id")
  private Department department;

  @OneToOne
  @JoinColumn(name="family_id")
  private EmployeeFamily employeeFamily;

  public static Employee createEmployee(Department department, EmployeeCreateDto employeeCreateDto) {
    // 사원가족 객체 생성
    Employee employee = new Employee();
    employee.setEmpId(employeeCreateDto.getEmpId());
    employee.setEmpName(employeeCreateDto.getEmpName());
    employee.setEmpType(employeeCreateDto.getEmpType());
    employee.setDepartment(department);

    // 샤원 객체 생성
    EmployeeFamily employeeFamily = new EmployeeFamily();
    employeeFamily.setFamilyId(employeeCreateDto.getEmpId());
    employeeFamily.setFamilyName(employeeCreateDto.getEmpName());
    employeeFamily.setFamilyType(employeeCreateDto.getFamilyType());

    // 객체 연관관계 설정
    employee.setDepartment(department);
    employee.setEmployeeFamily(employeeFamily);

    return employee;
  }
}