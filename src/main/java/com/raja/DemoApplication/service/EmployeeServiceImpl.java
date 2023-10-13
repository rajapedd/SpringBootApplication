package com.raja.DemoApplication.service;

import com.raja.DemoApplication.error.EmployeeNotFoundException;
import com.raja.DemoApplication.model.Employee;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;


@Service
public class EmployeeServiceImpl implements EmployeeService{

    List<Employee> employees =  new ArrayList<>();
    @Override
    public Employee save(Employee emp) {
        if(null==emp.getEmployeeId()  || emp.getEmployeeId().isEmpty()){
            emp.setEmployeeId(UUID.randomUUID().toString());
        }
        employees.add(emp);
        return emp;
    }

    @Override
    public List<Employee> getAllEmployees() {
        return employees;
    }

    @Override
    public Employee getEmployeeById(String id) {
       // employees.stream().filter(emp->emp.getEmployeeId().equals(id)).findFirst().get();
       return employees.stream().filter(emp->emp.getEmployeeId().equals(id)).findFirst().orElseThrow(() -> new RuntimeException("" +"Employee is Not Found For ID :"+id));
       // return employees.stream().filter(emp->emp.getEmployeeId().equals(id)).findFirst().orElseThrow(() -> new EmployeeNotFoundException("" +"Employee is Not Found For ID :"+id));
    }

    @Override
    public String deleteEmployeeById(String id) {
        Employee emp = employees.stream().filter(i->i.getEmployeeId().equalsIgnoreCase(id)).findFirst().get();
        employees.remove(emp);
        return "Employee Deleted Successfully......! "+id;
    }
}
