package com.jwt.ms.elk.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jwt.ms.elk.demo.model.Employee;
import com.jwt.ms.elk.demo.repo.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	EmployeeRepository employeeRepository;

	@Override
	public List<Employee> getEmployees() {
		return employeeRepository.findAll();
	}

	@Override
	public Optional<Employee> getEmployeeById(int empid) {
		return employeeRepository.findById(empid);
	}

	@Override
	public Employee addNewEmployee(Employee emp) {
		return employeeRepository.save(emp);
	}

	@Override
	public Employee updateEmployee(Employee emp) {
		return employeeRepository.save(emp);
	}

	@Override
	public void deleteEmployeeById(int empid) {
		employeeRepository.deleteById(empid);

	}

	@Override
	public void deleteAllEmployees() {
		employeeRepository.deleteAll();

	}

}
