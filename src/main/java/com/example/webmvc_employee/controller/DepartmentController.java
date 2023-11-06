package com.example.webmvc_employee.controller;

import com.example.webmvc_employee.entity.Department;
import com.example.webmvc_employee.service.DepartmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/departments")
@RequiredArgsConstructor
public class DepartmentController {
  private final DepartmentService departmentService;

  @GetMapping()
  public List<Department> getAllDepartments() {
    return departmentService.getAllDepartments();
  }

  @GetMapping("/{deptId}")
  public Department getDepartment(@PathVariable int deptId) {

    return departmentService.getDepartment(deptId);
  }

  @PostMapping
  public String addDepartment(@RequestBody Department department) {
    departmentService.addDepartment(department);
    return "등록완료";
  }

  @PutMapping("/{deptId}")
  public String updateDepartment( @PathVariable int deptId,
                                  @RequestBody Department department) {
//        department.setDeptId(deptId);
    departmentService.updateDepartment(department);
    return "수정완료";
  }

  @DeleteMapping("/{deptId}")
  public String deleteDepartment(@PathVariable int deptId) {
    departmentService.deleteDepartment(deptId);
    return "삭제완료";
  }
}