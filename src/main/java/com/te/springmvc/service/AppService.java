package com.te.springmvc.service;

import com.te.springmvc.entity.dto.EmployeeDto;
import com.te.springmvc.entity.dto.EmployeeUpdatedDto;

public interface AppService {
	
	public EmployeeDto register(EmployeeDto employeeDto);	

	public EmployeeDto getEmployeeDetails(int employeeId);

	public EmployeeUpdatedDto updateEmployeeDetails(int employeeId,EmployeeUpdatedDto employeeUpdatedDto);
	
	public boolean deleteEmployeeDetails(int employeeId);

}
