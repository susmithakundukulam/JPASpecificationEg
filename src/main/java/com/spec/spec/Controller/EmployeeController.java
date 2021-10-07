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
	
	@PostMapping("getAllEmployees")
	public ResponseEntity getAllEmployees() ;
	
	@PostMapping("getAllEmployeesQuery")
	public ResponseEntity getAllEmployeesQuery() ;
	
	@PostMapping("getAllEmployeesQuery1")
	public ResponseEntity getAllEmployeesQuery1() ;
	
	@PostMapping("getAllEmployeesQuery2")
	public ResponseEntity getAllEmployeesQuery2(@RequestBody EmployeeDto empDto) ;
	
	@PostMapping("getAllEmployeesQuery3")
	public ResponseEntity getAllEmployeesQuery3(@RequestBody EmployeeDto empDto) ;
}
