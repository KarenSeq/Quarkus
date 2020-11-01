package org.acme.spring.web.controller;

import java.util.List;

import javax.transaction.Transactional;

import org.acme.spring.web.model.Employee;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controls the flow of data
 * @author Karen
 *
 */
@RestController
@RequestMapping("/springweb")
public class EmployeeController {

    @GetMapping("/hello")
    public String hello() {
        return "hello";
    }
    
    @PostMapping("add")
    @Transactional
    public void addEmployee(Employee employee) {
    	Employee.persist(employee);
    }
    
    @GetMapping("list")
    public List<Employee> getAllEmployees() {
    	return Employee.listAll();
    }
    
    
}
