package com.example.MyBatisSpringBoot.controller;

import com.example.MyBatisSpringBoot.mapper.EmployeeMapper;
import com.example.MyBatisSpringBoot.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/ui")
public class EmployeeController {
    @Autowired
    private EmployeeMapper employeeMapper;
    @GetMapping("/initPage")
    public String initPage(Model model){
        model.addAttribute("initEmployee" , new Employee());
        model.addAttribute("listOfEmployees" , employeeMapper.getAll());
        return "addEmployee";
    }

    @PostMapping("/newEmployee")
    public String saveUser(@ModelAttribute("initEmployee") Employee employee){
        employeeMapper.save(employee);
        return "redirect:/ui/initPage";
    }

    @GetMapping("/delete/{id}")
    public String deleteUser(@PathVariable("id") int id){
        employeeMapper.deleteEmployee(id);
        return "redirect:/ui/initPage";
    }
    @GetMapping("/edit/{id}")
    public String editUser(@PathVariable("id") int id, Model model){
        Employee employee = employeeMapper.selectEmployee(id);
        model.addAttribute("editEmployee" , employee);
        model.addAttribute("listOfEmployees" , employeeMapper.getAll());
        return "editEmployee";
    }

    @PutMapping("/editEmployee")
    public String editUser(@ModelAttribute("editEmployee") Employee employee){

        employeeMapper.updateEmployee(employee);
        return "redirect:/ui/initPage";
    }


}
