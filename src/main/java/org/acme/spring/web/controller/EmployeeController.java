package org.acme.spring.web.controller;

import java.util.List;

import javax.transaction.Transactional;

import org.acme.spring.web.model.Employee;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.media.Content;
import org.eclipse.microprofile.openapi.annotations.media.Schema;
import org.eclipse.microprofile.openapi.annotations.parameters.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controls the flow of data
 * 
 * @author Karen
 *
 */
@RestController("springweb")
@RequestMapping("/springweb")
public class EmployeeController {

	@GetMapping("hello")
	@Operation(summary = "Returns a string",
	description = "Simple get method added for no reason")
	public String hello() {
		return "hello";
	}

	@PostMapping("add")
	@Transactional
	@RequestBody(description ="Adds a new employee",
	content = @Content(mediaType = "application/json", schema = @Schema(implementation = Employee.class)))
	public void addEmployee(Employee employee) {
		Employee.persist(employee);
	}

	@GetMapping("list")
	@Operation(summary = "Displays all the employee from h2 database",
	description = "Returns a list of all employees")
	public List<Employee> getAllEmployees() {
		return Employee.listAll();
	}

}
