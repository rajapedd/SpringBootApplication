package com.raja.DemoApplication.controller;

import com.raja.DemoApplication.model.Employee;
import com.raja.DemoApplication.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v2/employees")
public class EmployeeV2Controller {

    @Qualifier("employeeV2ServiceImpl")
    @Autowired
    private EmployeeService empService;



    @PostMapping
    public Employee createEmployee(@RequestBody Employee emp){
        return empService.save(emp);
    }



    @GetMapping
    public List<Employee> getEmployee(){
        List<Employee> allEmployees = empService.getAllEmployees();
        return allEmployees;
    }

    @GetMapping("/{id}")
    public Employee getEmployeeById(@PathVariable String id){
        return empService.getEmployeeById(id);
    }

    @DeleteMapping("/{id}")
    public String deleteEmp(@PathVariable String id){
        return empService.deleteEmployeeById(id);
    }

}
