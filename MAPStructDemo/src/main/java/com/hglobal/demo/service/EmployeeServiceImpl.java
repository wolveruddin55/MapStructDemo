package com.hglobal.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.hglobal.demo.entity.EmployeeModel;
import com.hglobal.demo.mapper.ModelToDTOMapper;
import com.hglobal.demo.repository.EmployeeRepository;
import com.hglobal.demo.requestbody.EmployeeRequestBody;
import com.hglobal.demo.utility.CustomException;
import com.hglobal.demo.utility.Result;
import com.hglobal.demo.utility.Utility;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	EmployeeRepository employeeRepository;
	
	@Autowired
	ModelToDTOMapper modelToDTOMapper;
	
	@Override
	public Result getAllEmployees(EmployeeRequestBody employeeRequestBody) {
		Result result= new Result();
		try {
			Pageable pageable = PageRequest.of(employeeRequestBody.getPageNo().intValue(),
					employeeRequestBody.getPageSize().intValue(), Sort.by(employeeRequestBody.getSortBy()));
			Page<EmployeeModel> employeesList =employeeRepository.findAll(pageable);
			if(employeesList.isEmpty()) {
				result.setStatusCode(HttpStatus.NOT_FOUND.value());
				result.setMessage(Utility.NO_RECORDS_TO_DISPLAY);
			}else {
				result.setStatusCode(HttpStatus.OK.value());
				result.setMessage(Utility.FETCHING_RECORDS);
				result.setObject(modelToDTOMapper.fromEmployeeModel(employeesList.toList()));
			}
		} catch (Exception e) {
			log.error(">>>>>>>>>>>>>>>>> getAllEmployees", e.getMessage());
			throw new CustomException(HttpStatus.INTERNAL_SERVER_ERROR.value(), e.getMessage());
		}
		return result;
	}

}
