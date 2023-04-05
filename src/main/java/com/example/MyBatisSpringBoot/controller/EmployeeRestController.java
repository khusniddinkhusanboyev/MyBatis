package com.example.MyBatisSpringBoot.controller;


import com.example.MyBatisSpringBoot.mapper.EmployeeMapper;
import com.example.MyBatisSpringBoot.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rest/employees")
public class EmployeeRestController {
    @Autowired
    private EmployeeMapper employeeMapper;

    @GetMapping("/all")
    public List<Employee> getAll(){
    return employeeMapper.getAll();
    }

    @GetMapping("/findById/{id}")
    public Employee getById(@PathVariable("id") int id){
       return employeeMapper.selectEmployee(id);
    }

    @PostMapping("/save")
    public void saveUser(@RequestBody Employee employee){
       employeeMapper.save(employee);
    }

    @PutMapping("/update/{id}")
    public void updateUser(@PathVariable("id") int id,@RequestBody Employee employee){
       Employee employee1 = employeeMapper.selectEmployee(id);
       employee1.setName(employee.getName());
       employee1.setSalary(employee.getSalary());
       employeeMapper.updateEmployee(employee1);

    }

    @PostMapping("/delete/{id}")
    public void deleteUserById(@PathVariable("id") int id){
        employeeMapper.deleteEmployee(id);
    }
}
