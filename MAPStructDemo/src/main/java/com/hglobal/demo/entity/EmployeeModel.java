package com.hglobal.demo.entity;


import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="employee")
public class EmployeeModel {

	@Id
	@Column(name="employee_id")
	private Integer employeeId;
	
	@Column(name="employeename")
	private String employeeName;

	@Column(name="department")
	private String department;
	
	@Column(name="email_id")
	private String emailId;
	
	@Column(name="password")
	private String password;

	@Column(name="joiningdate")
	private Date joiningDate;
	
	@Column(name="date_of_birth")
	private Date dateOfBirth;
	
	@Column(name="is_Active")
	private String isActive;
}
