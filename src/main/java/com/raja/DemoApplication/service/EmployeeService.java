package com.raja.DemoApplication.service;

import com.raja.DemoApplication.model.Employee;

import java.util.List;

public interface EmployeeService {

    Employee save(Employee emp);

    List<Employee> getAllEmployees();

    Employee getEmployeeById(String id);

    String deleteEmployeeById(String id);
}
