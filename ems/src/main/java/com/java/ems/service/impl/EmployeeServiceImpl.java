package com.java.ems.service.impl;

import com.java.ems.dto.EmployeeDto;
import com.java.ems.entity.Employee;
import com.java.ems.exception.ResourceNotFoundException;
import com.java.ems.repository.EmployeeRepository;
import com.java.ems.service.EmployeeService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }


    @Override
    public EmployeeDto createEmployee(EmployeeDto employee) {
        Employee emp = new Employee(employee.getEmpId(), employee.getEmpName(), employee.getDepartment(), employee.getSalary());
        Employee saved = employeeRepository.save(emp);
        return mapToDto(saved);
    }

    @Override
    public List<EmployeeDto> getAllEmployees() {
        return employeeRepository.findAll().stream().map(this::mapToDto).collect(Collectors.toList());
    }

    @Override
    public EmployeeDto getEmployeeById(String empId) {
        Employee emp = employeeRepository.findById(empId).orElseThrow(
                ()-> new ResourceNotFoundException("Employee not found")
        );
        return mapToDto(emp);
    }

    @Override
    public EmployeeDto updateEmployee(String empId, EmployeeDto employee) {
        Employee emp = employeeRepository.findById(empId).orElseThrow(
                ()-> new ResourceNotFoundException("Employee not found")
        );
        emp.setEmpName(employee.getEmpName());
        emp.setDepartment(employee.getDepartment());
        emp.setSalary(employee.getSalary());
        return mapToDto(employeeRepository.save(emp));
    }

    @Override
    public void deleteEmployee(String empId) {
        Employee emp = employeeRepository.findById(empId).orElseThrow(
                ()-> new ResourceNotFoundException("Employee not found")
        );
        employeeRepository.delete(emp);
    }

    private EmployeeDto mapToDto(Employee emp) {
        return new EmployeeDto(emp.getEmpId(), emp.getEmpName(), emp.getDepartment(), emp.getSalary());
    }
}
