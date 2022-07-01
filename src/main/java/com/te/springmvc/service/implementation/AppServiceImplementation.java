package com.te.springmvc.service.implementation;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.te.springmvc.entity.Employee;
import com.te.springmvc.entity.dto.EmployeeDto;
import com.te.springmvc.entity.dto.EmployeeUpdatedDto;
import com.te.springmvc.repository.AppRepository;
import com.te.springmvc.service.AppService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AppServiceImplementation implements AppService {

	public final AppRepository appRepository;

	@Override
	public EmployeeDto register(EmployeeDto employeeDto) {

		Employee employee = new Employee();
		BeanUtils.copyProperties(employeeDto, employee);
		Employee register = appRepository.register(employee);
		BeanUtils.copyProperties(register, employeeDto);
		return employeeDto;
	}

	@Override
	public EmployeeDto getEmployeeDetails(int employeeId) {

		Employee employee = appRepository.findByEmployeeId(employeeId);
		EmployeeDto employeeDto = new EmployeeDto();
		BeanUtils.copyProperties(employee, employeeDto);
		return employeeDto;
	}

	@Override
	public EmployeeUpdatedDto updateEmployeeDetails(int employeeId, EmployeeUpdatedDto employeeUpdateDto) {
		Employee employee = appRepository.findByEmployeeId(employeeId);
		BeanUtils.copyProperties(employeeUpdateDto, employee);
		Employee updateEmployee = appRepository.register(employee);
		BeanUtils.copyProperties(updateEmployee, employeeUpdateDto );
		return employeeUpdateDto ;
	}

	@Override
	public boolean deleteEmployeeDetails(int employeeId) {
		boolean isDeleted = appRepository.deleteEmployeeDetails(employeeId);
		return isDeleted;
	}
}
