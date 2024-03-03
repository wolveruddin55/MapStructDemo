package com.hglobal.demo.service;

import com.hglobal.demo.requestbody.EmployeeRequestBody;
import com.hglobal.demo.utility.Result;

public interface EmployeeService {

	public Result getAllEmployees(EmployeeRequestBody employeeRequestBody);
}
