package com.example.webmvc_employee.repository;

import com.example.webmvc_employee.entity.Employee;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@SpringBootTest
class EmployeeRepositoryTest {
  @Autowired
  com.example.webmvc_employee.repository.EmployeeRepository employeeRepository;

  @Test
  @Transactional
  void findAll() {
    //given employee
    Employee employee = new Employee();
    employee.setEmpId("202301");
    employee.setEmpName("홍길동");
    employeeRepository.save(employee);
    //when
    List<Employee> employees = employeeRepository.findAll();
    //then
    Assertions.assertThat(employees.size()).isEqualTo(1);
  }

  @Test
  @Transactional
  void findOne() {
    //given employee
    //when
    Employee employee = employeeRepository.findById("202302");
    Employee employee2 = employeeRepository.findById("202301");
    //then
    Assertions.assertThat(employee).isEqualTo(null);
    Assertions.assertThat(employee2.getEmpName()).isEqualTo("홍길동");
  }

  @Test
  @Transactional
  void saveAndUpdate() {
    //given employee
    Employee first = employeeRepository.findById("202301");//when
    first.setEmpName("홍길동2");
    //when employee
    employeeRepository.save(first);
    List<Employee> all = employeeRepository.findAll();
    //then
    Assertions.assertThat(first.getEmpName()).isEqualTo("홍길동2");
    Assertions.assertThat(all.size()).isEqualTo(1);
  }

  @Test
  @Transactional
  void delete() {
    //given employee
    Employee first = employeeRepository.findById("202301");//when
    employeeRepository.delete(first);
    List<Employee> all = employeeRepository.findAll();
    //then
    Assertions.assertThat(all.size()).isEqualTo(0);
  }
}