package com.patil.software.solutions.service;

import java.util.List;

import com.patil.software.solutions.model.Employee;

public interface EmployeeService {
	public Employee save(Employee employee);

	public List<Employee> getAllEmployee();

	public Employee getEmployeeByID(String employeeId);

	public String deleteByEmployeeByID(String employeeId);
}
