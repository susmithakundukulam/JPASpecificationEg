package com.spec.spec.Controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spec.spec.dto.EmployeeDto;

@RestController
@RequestMapping("employee")
public interface EmployeeController {
	
	//http://localhost:8080/spec/employee/getAllEmployees
	@PostMapping("getAllEmployees")
	public ResponseEntity getAllEmployees() ;
	
	//http://localhost:8080/spec/employee/getAllEmployeesQuery
	@PostMapping("getAllEmployeesQuery")
	public ResponseEntity getAllEmployeesQuery() ;
	
	//http://localhost:8080/spec/employee/getAllEmployeesQuery1
	@PostMapping("getAllEmployeesQuery1")
	public ResponseEntity getAllEmployeesQuery1() ;
	
	//http://localhost:8080/spec/employee/getAllEmployeesQuery2
	//{"id" : 2,"firstName" : "Susmitha","lastName" : "k"}
	@PostMapping("getAllEmployeesQuery2")
	public ResponseEntity getAllEmployeesQuery2(@RequestBody EmployeeDto empDto) ;
	
	//http://localhost:8080/spec/employee/getAllEmployeesQuery3
	//{"id" : 2,"firstName" : "Susmitha","lastName" : "k"}
	@PostMapping("getAllEmployeesQuery3")
	public ResponseEntity getAllEmployeesQuery3(@RequestBody EmployeeDto empDto) ;
	
	//http://localhost:8080/spec/employee/getAllEmployeesByName
	@PostMapping("getAllEmployeesByName")
	public ResponseEntity getAllEmployeesByName() ;
	
	
	//http://localhost:8080/spec/employee/getAllEmployeesSpec
	@PostMapping("getAllEmployeesSpec")
	public ResponseEntity getAllEmployeesSpec() ;
}
