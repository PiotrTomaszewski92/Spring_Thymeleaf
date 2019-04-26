package com.springboot.thymeleafdemo.controller;
import com.springboot.thymeleafdemo.entity.Employee;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/employees")
public class EmployeeController {
    private List<Employee> employees;

    @PostConstruct
    private void loadData(){
        employees = new ArrayList<>();
        employees.add(new Employee(1, "Piotr", "Tomaszewski", "piotr@tomaszew.com"));
        employees.add(new Employee(2, "Adam", "Tomaszewski", "adamtomkrk@gmail.com"));
        employees.add(new Employee(3,"Daniel", "Kłusek", "firgasto@gmail.com"));
    }

    @GetMapping("/list")
    public String listEmployees(Model model){
        model.addAttribute("employees",employees);
        return "list-employees";
    }
}

