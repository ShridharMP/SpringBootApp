package com.patil.software.solutions.service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.patil.software.solutions.model.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	List<Employee> employees = new ArrayList<>();

	@Override
	public Employee save(Employee employee) {
		if (employee.getEmployeeId() == null || employee.getMailId().isEmpty()) {
			employee.setEmployeeId(UUID.randomUUID().toString());
		}
		employees.add(employee);
		return employee;
	}

	@Override
	public List<Employee> getAllEmployee() {
		return employees;
	}

	@Override
	public Employee getEmployeeByID(String employeeId) {
		return employees.stream().filter(employee -> employee.getEmployeeId().equals(employeeId)).findFirst()
				.orElseThrow(() -> new RuntimeException("Employee Not Found for given Id " + employeeId));

	}

	@Override
	public String deleteByEmployeeByID(String employeeId) {
		Employee employee = employees.stream().filter(e -> e.getEmployeeId().equalsIgnoreCase(employeeId)).findFirst()
				.get();
		employees.remove(employee);
		return "Employee details deleted for the given ID:" + employeeId;
	}
}
