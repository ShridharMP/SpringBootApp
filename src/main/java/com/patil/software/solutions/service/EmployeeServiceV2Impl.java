package com.patil.software.solutions.service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.patil.software.solutions.entity.EmployeeEntity;
import com.patil.software.solutions.model.Employee;
import com.patil.software.solutions.repository.EmployeeEntityRepository;

@Service
public class EmployeeServiceV2Impl implements EmployeeService {

	@Autowired
	private EmployeeEntityRepository employeeEntityRepository;

	public Employee save(Employee employee) {
		if (employee.getEmployeeId() == null || employee.getMailId().isEmpty()) {
			employee.setEmployeeId(UUID.randomUUID().toString());
		}
		EmployeeEntity entity = new EmployeeEntity();
		BeanUtils.copyProperties(employee, entity);
		employeeEntityRepository.save(entity);
		return employee;
	}

	@Override
	public List<Employee> getAllEmployee() {
		List<EmployeeEntity> employeeEntityList = employeeEntityRepository.findAll();
		List<Employee> employees = employeeEntityList.stream().map(employeeEntity -> {
			Employee employee = new Employee();
			BeanUtils.copyProperties(employeeEntity, employee);
			return employee;
		}).collect(Collectors.toList());
		return employees;
	}

	@Override
	public Employee getEmployeeByID(String employeeId) {
		EmployeeEntity employeeEntity = employeeEntityRepository.findById(employeeId).get();
		Employee employee = new Employee();
		BeanUtils.copyProperties(employeeEntity, employee);
		return employee;
	}

	@Override
	public String deleteByEmployeeByID(String employeeId) {
		employeeEntityRepository.deleteById(employeeId);
		return "Employee details deleted for the given ID:" + employeeId;
	}
}
