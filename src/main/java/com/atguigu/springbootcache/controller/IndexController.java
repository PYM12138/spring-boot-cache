package com.atguigu.springbootcache.controller;

import com.atguigu.springbootcache.bean.Employee;
import com.atguigu.springbootcache.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IndexController {

    @Autowired
    EmployeeService employeeService;



    @GetMapping("/emp/{id}")
    public Employee getEmp(@PathVariable Integer id){
        return employeeService.getEmpSingle(id);
    }

    /*@GetMapping("/emp")
    public Employee updateEmp(Employee employee){
        employeeService.updateEmpSingle(employee);
        return employee;
    }*/

    @GetMapping("/emp")
    public String delEmp(Integer id){
        employeeService.delEmp(id);
        return "success";
    }


}
