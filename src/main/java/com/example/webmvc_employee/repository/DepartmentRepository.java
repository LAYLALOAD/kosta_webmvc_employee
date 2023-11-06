package com.example.webmvc_employee.repository;

import com.example.webmvc_employee.entity.Department;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor // 생성자 + autowired
public class DepartmentRepository {
  @PersistenceContext
  private final EntityManager em;

  // CRUD
  public List<Department> findAll() {
    return em.createQuery("select d from Department d", Department.class)
        .getResultList();
  }

  public Department findById(int deptId) {
    return em.find(Department.class, deptId);
  }

  public void save(Department department) { // insert & update
    em.persist(department);
  }

  public void delete(Department department) {
    em.remove(department);
  }
}