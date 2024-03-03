package com.hglobal.demo.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import com.hglobal.demo.dto.EmployeeDTO;
import com.hglobal.demo.entity.EmployeeModel;
import com.hglobal.demo.utility.Utility;

@Mapper(componentModel = "spring")
public interface ModelToDTOMapper {

	ModelToDTOMapper MAPPERInstance = Mappers.getMapper(ModelToDTOMapper.class);

	@Mapping(source = "dateOfBirth", target = "dateOfBirth", dateFormat = Utility.DATE_FORMAT)
	@Mapping(source = "joiningDate", target = "joiningDate", dateFormat = Utility.DATE_FORMAT)
	@Mapping(source = "employeeId", target = "id")
	EmployeeDTO fromEmployeeModel(EmployeeModel employeeModel);

	List<EmployeeDTO> fromEmployeeModel(List<EmployeeModel> employeeModel);
}
