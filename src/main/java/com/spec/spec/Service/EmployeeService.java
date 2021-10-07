package com.spec.spec.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spec.spec.DAO.EmployeeDAO;
import com.spec.spec.dto.EmployeeDto;
import com.spec.spec.model.Employee;
import com.spec.spec.utils.GeneralUtils;

@Service
public class EmployeeService {
	
	@Autowired
	private EmployeeDAO employeeDAO;
	
	@Autowired
	private GeneralUtils generalUtils;
	
	public List<EmployeeDto> getAllEmployee(){
		 List<Employee> empEntityList = employeeDAO.findAll();
		 List<EmployeeDto> finalEmployeeList = new ArrayList<EmployeeDto>();
		 for(Employee emp : empEntityList) {
			 finalEmployeeList.add(generalUtils.map(emp, EmployeeDto.class)); 
		 }
		 return finalEmployeeList;
	}
	
	public List<EmployeeDto> getAllEmployeeQuery(){
		List<EmployeeDto> empDtoList = new ArrayList<EmployeeDto>();
		List<Employee> empList = employeeDAO.findAllQuery(2);
		for(Employee emp : empList) {
			empDtoList.add(generalUtils.map(emp, EmployeeDto.class));
			
		}
		return empDtoList;
	}
	
	public List<EmployeeDto> getAllEmployeeQuery1(){
		List<EmployeeDto> empDtoList =new ArrayList<EmployeeDto>();
		List<Employee> empList = employeeDAO.findAllQuery1(3);
		for(Employee emp: empList){
			empDtoList.add(generalUtils.map(emp, EmployeeDto.class));
		}
		return empDtoList;
	}
	
	public List<EmployeeDto> getAllEmployeeQuery2(EmployeeDto empDto){
		List<EmployeeDto> empDtoList =new ArrayList<EmployeeDto>();
		System.out.println("*************");

		Employee empEntity = generalUtils.map(empDto, Employee.class);
		System.out.println("*************"+ empEntity.getId());
		List<Employee> empList = employeeDAO.findAllQuery2(empEntity.getId());
		for(Employee emp: empList){
			empDtoList.add(generalUtils.map(emp, EmployeeDto.class));
		}
		return empDtoList;
	}

	public List<EmployeeDto> getAllEmployeeQuery3(EmployeeDto empDto){
		List<EmployeeDto> empDtoList =new ArrayList<EmployeeDto>();
		System.out.println("*************");

		Employee empEntity = generalUtils.map(empDto, Employee.class);
		System.out.println("*************"+ empEntity.getId());
		List<Employee> empList = employeeDAO.findAllQuery3(empEntity);
		for(Employee emp: empList){
			empDtoList.add(generalUtils.map(emp, EmployeeDto.class));
		}
		return empDtoList;
	}
}
