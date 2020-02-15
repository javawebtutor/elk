package com.jwt.ms.elk.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jwt.ms.elk.demo.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

}
