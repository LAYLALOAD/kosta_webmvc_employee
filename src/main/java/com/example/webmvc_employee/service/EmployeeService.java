package com.example.webmvc_employee.service;

import com.example.webmvc_employee.dto.EmployeeCreateDto;
import com.example.webmvc_employee.dto.EmployeeUpdateDto;
import com.example.webmvc_employee.entity.Department;
import com.example.webmvc_employee.entity.Employee;
import com.example.webmvc_employee.entity.EmployeeFamily;
import com.example.webmvc_employee.repository.DepartmentRepository;
import com.example.webmvc_employee.repository.EmployeeRepository;
import com.example.webmvc_employee.repository.FamilyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class EmployeeService {
  private final DepartmentRepository departmentRepository;
  private final EmployeeRepository employeeRepository;
  private final FamilyRepository familyRepository;

  @Transactional(readOnly = true)
  public List<Employee> getAllEmployees() {
    return employeeRepository.findAll();
  }
  @Transactional(readOnly = true)
  public Employee getEmployee(String empId) {
    return employeeRepository.findById(empId);
  }

  public void addEmployee(EmployeeCreateDto employeeCreateDto){
    //int deptId, Employee employee, EmployeeFamily family) {
    Department department = departmentRepository.findById(employeeCreateDto.getDeptId());
    Employee employee = Employee.createEmployee(department, employeeCreateDto);
    employeeRepository.save(employee);
    EmployeeFamily family = employee.getEmployeeFamily();
    familyRepository.save(family);
  }

  public void updateEmployee(EmployeeUpdateDto employeeUpdateDto) {
    Employee employee = employeeRepository.findById(employeeUpdateDto.getEmpId());
    employee.setEmpType(employeeUpdateDto.getEmpType());
    employee.setSalary(employeeUpdateDto.getSalary());
    employeeRepository.save(employee);
  }

  public void deleteEmployee(String empId) {
    Employee emp = employeeRepository.findById(empId);
    if(emp != null) {
      employeeRepository.delete(emp);
    }
  }
}