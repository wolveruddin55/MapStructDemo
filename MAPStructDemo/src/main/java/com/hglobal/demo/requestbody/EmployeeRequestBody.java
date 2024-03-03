package com.hglobal.demo.requestbody;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeRequestBody {

	private Integer pageNo;
	private Integer pageSize;
	private String sortBy;
	private boolean export;
}
