package com.jwt.ms.elk.demo.controller;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.jwt.ms.elk.demo.model.Employee;
import com.jwt.ms.elk.demo.service.EmployeeService;

@RestController
public class EmployeeController {

	private ThreadLocal<Long> time = new ThreadLocal<>();

	@Autowired
	EmployeeService employeeService;

	private static final Logger LOG = LoggerFactory.getLogger(EmployeeController.class);

	@GetMapping("/employee/all")
	public List<Employee> getEmployees() {
		long time = System.currentTimeMillis();
		String requestId = "REQ" + Math.random();
		LOG.info("Starting to fetch all employees info for request :{}", requestId);
		List<Employee> employees = employeeService.getEmployees();
		long responseTime = (System.currentTimeMillis() - time);
		LOG.info("[Time: {} ms] [RequestID: {} ] [Respone: {} ]{} {}", responseTime, requestId, employees);
		return employees;

	}
	
	@GetMapping("/employee/{empid}")
	public Employee getEmployeeById(@PathVariable("empid") int empid) throws Exception{
		long time = System.currentTimeMillis();
		String requestId = "REQ" + Math.random();
		LOG.info("Starting to fetch all employees info for request :{}", requestId);
		Optional<Employee> employee = employeeService.getEmployeeById(empid);
		if(!employee.isPresent()) {
			throw new Exception("Could not find employee with id- " + empid);
		}
		long responseTime = (System.currentTimeMillis() - time);
		LOG.info("[Time: {} ms] [RequestID: {} ] [Respone: {} ]{} {}", responseTime, requestId, employee.toString());
		return employee.get();
	}
	@PostMapping( "/employee/add")
    public Employee createEmployee(@RequestBody Employee newemp) {
		LOG.info("start createEmployee method in {} ", EmployeeController.class.getName());
		LOG.debug("Request : {}", newemp.toString());
		String requestId = "REQ" + Math.random();
		long time = System.currentTimeMillis();
		long responseTime = (System.currentTimeMillis() - time);
		LOG.info("[Time: {} ms] [RequestID: {} ] [Request: {} ]{} {}", responseTime, requestId, newemp.toString());
        return employeeService.addNewEmployee(newemp);
    }
	
	
}
