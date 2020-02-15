package com.jwt.ms.elk.demo.service;

import java.util.List;
import java.util.Optional;

import com.jwt.ms.elk.demo.model.Employee;

public interface EmployeeService {

	public List<Employee> getEmployees();

	public Optional<Employee> getEmployeeById(int empid);

	public Employee addNewEmployee(Employee emp);

	public Employee updateEmployee(Employee emp);

	public void deleteEmployeeById(int empid);

	public void deleteAllEmployees();

}
