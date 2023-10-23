package com.department.service.repository;





import org.springframework.data.jpa.repository.JpaRepository;

import com.department.service.entity.Department;



public interface DepartmentRepository extends JpaRepository<Department,Long> {
           Department findByDepartmentCode(String departmentCode);
}
