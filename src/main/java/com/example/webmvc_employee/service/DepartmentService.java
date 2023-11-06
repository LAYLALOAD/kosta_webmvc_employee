package com.example.webmvc_employee.service;

import com.example.webmvc_employee.entity.Department;
import com.example.webmvc_employee.repository.DepartmentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class DepartmentService {
  private final DepartmentRepository departmentRepository;
  @Transactional(readOnly = true)
  public List<Department> getAllDepartments() {
    return departmentRepository.findAll();
  }
  @Transactional(readOnly = true)
  public Department getDepartment(int deptId) {
    return departmentRepository.findById(deptId);
  }

  public void addDepartment(Department department) {
    departmentRepository.save(department);
  }

  public void updateDepartment(Department department) {
    // 주의 - detached entity가 persist되지 않도록 할 것
    Department findDepartment = departmentRepository.findById(department.getDeptId());
    findDepartment.setDeptName(department.getDeptName());
    //departmentRepository.save(department);
    departmentRepository.save(findDepartment);
  }

  public void deleteDepartment(int deptId) {
    Department findDepartment = departmentRepository.findById(deptId);
    departmentRepository.delete(findDepartment);
  }
}