package com.java.ems.service;

import com.java.ems.dto.EmployeeDto;

import java.util.List;

public interface EmployeeService {

    public EmployeeDto createEmployee(EmployeeDto employee);

    public List<EmployeeDto> getAllEmployees();

    public EmployeeDto getEmployeeById(String empId);

    public EmployeeDto updateEmployee(String empId, EmployeeDto employee);

    public void deleteEmployee(String empId);
}
