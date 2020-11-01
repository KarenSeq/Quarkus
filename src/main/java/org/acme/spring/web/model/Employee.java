package org.acme.spring.web.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import lombok.Data;

/**
 * POJO class for defining properties of an employee.
 * @author Karen
 *
 */
@Data
@Entity(name = "employee")
public class Employee extends PanacheEntityBase{
	
	@Id
	@Column(name = "employee_id")
	private String employeeId;
	@Column(name = "employee_name")
	private String employeeName;
	
}
