package com.raja.DemoApplication.service;


import com.raja.DemoApplication.entity.EmployeeEntity;
import com.raja.DemoApplication.model.Employee;
import com.raja.DemoApplication.repository.EmployeeRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;


@Service
public class EmployeeV2ServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;
    @Override
    public Employee save(Employee emp) {
        if(null==emp.getEmployeeId()  || emp.getEmployeeId().isEmpty()){
            emp.setEmployeeId(UUID.randomUUID().toString());
        }
        EmployeeEntity entity= new EmployeeEntity();
        BeanUtils.copyProperties(emp,entity);
        employeeRepository.save(entity);

        return emp;
    }

    @Override
    public List<Employee> getAllEmployees() {
        List<EmployeeEntity> entityList = employeeRepository.findAll();
        List<Employee> emp = entityList.stream().map(employeeEntity -> {
            Employee e= new Employee();
            BeanUtils.copyProperties(employeeEntity,e);
            return e;
        }).collect(Collectors.toList());
        return emp;
    }
    @Override
    public Employee getEmployeeById(String id) {
        EmployeeEntity empEntity =employeeRepository.findById(id).get();
        Employee emp = new Employee();
        BeanUtils.copyProperties(empEntity,emp);
        return emp;
    }

    @Override
    public String deleteEmployeeById(String id) {
        employeeRepository.deleteById(id);
        return "Employee Deleted Successfully With ID :"+id;
    }
}
