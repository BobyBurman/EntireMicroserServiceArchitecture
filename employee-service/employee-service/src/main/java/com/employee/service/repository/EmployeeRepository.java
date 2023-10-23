package com.employee.service.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.employee.service.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee,Long> {

}
