package com.hglobal.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class EmployeeDTO{
	private Integer id;
	private String employeeName;
	private String department;
	private String emailId;
	private String password;
	private String joiningDate;
	private String dateOfBirth;
	private String isActive;
}
