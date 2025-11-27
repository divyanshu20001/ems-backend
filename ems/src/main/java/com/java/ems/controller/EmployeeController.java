package com.java.ems.controller;

import com.java.ems.dto.EmployeeDto;
import com.java.ems.service.EmployeeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @PostMapping("/create")
    public ResponseEntity<EmployeeDto> createEmployee(@RequestBody EmployeeDto employee) {
        return ResponseEntity.ok(employeeService.createEmployee(employee));

    }

    @GetMapping("/fetchAll")
    public ResponseEntity<List<EmployeeDto>> getAllEmployees() {
        return ResponseEntity.ok(employeeService.getAllEmployees());

    }

    @GetMapping("/fetchById/{empId}")
    public ResponseEntity<EmployeeDto> getEmployeeById(@PathVariable String empId) {
        return ResponseEntity.ok(employeeService.getEmployeeById(empId));
    }

    @PutMapping("/update/{empId}")
    public ResponseEntity<EmployeeDto> updateEmployee(@PathVariable String empId, @RequestBody EmployeeDto employee) {
        return ResponseEntity.ok(employeeService.updateEmployee(empId,employee));
    }

    @DeleteMapping("/delete/{empId}")
    public ResponseEntity<String> deleteEmployee(@PathVariable String empId) {
        employeeService.deleteEmployee(empId);
        return ResponseEntity.ok("Employee deleted successfully.");
    }
}
