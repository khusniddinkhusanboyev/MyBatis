package com.example.MyBatisSpringBoot.model;

import org.springframework.stereotype.Component;

@Component
public class Employee {
    private Integer id;
    private String name;
    private Long salary;

    public Employee() {
    }

    public Employee(String name, Long salary) {
        this.name = name;
        this.salary = salary;
    }

    public Employee(Integer id, String name, Long salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSalary(Long salary) {
        this.salary = salary;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Long getSalary() {
        return salary;
    }
}
