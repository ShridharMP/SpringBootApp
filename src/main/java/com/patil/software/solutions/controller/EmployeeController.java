package com.patil.software.solutions.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.patil.software.solutions.model.Employee;
import com.patil.software.solutions.service.EmployeeService;

@RestController
@RequestMapping("/v1/employee")
public class EmployeeController {

	@Qualifier("employeeServiceImpl")
	@Autowired
	private EmployeeService employeeService;

	@PostMapping
	public Employee save(@RequestBody Employee employee) {
		return employeeService.save(employee);
	}

	@GetMapping
	public List<Employee> getAllEmployee() {
		return employeeService.getAllEmployee();
	}

	@GetMapping("/{id}")
	public Employee getEmployeeByID(@PathVariable("id") String employeeId) {
		return employeeService.getEmployeeByID(employeeId);
	}
	
	@DeleteMapping("/{id}")
	public String deleteByEmployeeByID(@PathVariable("id") String employeeId) {
		return employeeService.deleteByEmployeeByID(employeeId);
	}
}
