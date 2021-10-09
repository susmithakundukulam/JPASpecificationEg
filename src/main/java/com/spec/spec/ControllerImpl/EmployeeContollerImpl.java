package com.spec.spec.ControllerImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import com.spec.spec.Controller.EmployeeController;
import com.spec.spec.Service.EmployeeService;
import com.spec.spec.dto.EmployeeDto;
import com.spec.spec.dto.MessageHandler;
import com.spec.spec.dto.ResponseHandler;
import com.spec.spec.model.Employee;

@Controller
public class EmployeeContollerImpl implements EmployeeController{

	@Autowired
	private EmployeeService empService;
	
	@Override
	public ResponseEntity getAllEmployees() {
		System.out.println("inside oooooooooooooooooooooooooooooo");
		ResponseHandler responsehandler = new ResponseHandler();
		List<EmployeeDto> empList = empService.getAllEmployee();
		if(empList.isEmpty()) {
			responsehandler = new ResponseHandler(MessageHandler.FAILED);
		}else {
			responsehandler = new ResponseHandler(empList);
		}
		return new ResponseEntity(responsehandler, HttpStatus.OK);
	}

	@Override
	public ResponseEntity getAllEmployeesQuery() {
		ResponseHandler responseHandler = new ResponseHandler();
		List<EmployeeDto> emplList = empService.getAllEmployeeQuery();
		if(emplList.isEmpty()) {
			responseHandler = new ResponseHandler(MessageHandler.FAILED);
		}else {
			responseHandler = new ResponseHandler(emplList);
		}
		return new ResponseEntity(responseHandler, HttpStatus.OK);
	}

	@Override
	public ResponseEntity getAllEmployeesQuery1() {
		ResponseHandler responseHandler = new ResponseHandler();
		List<EmployeeDto> empList = empService.getAllEmployeeQuery1();
		if(empList.isEmpty()) {
			responseHandler = new ResponseHandler(MessageHandler.FAILED);
		}else {
			responseHandler  = new ResponseHandler(empList);
		}
		return new ResponseEntity(responseHandler, HttpStatus.OK);
	}
	
	@Override
	public ResponseEntity getAllEmployeesQuery2(EmployeeDto empDto) {
		ResponseHandler responseHandler = new ResponseHandler();
		List<EmployeeDto> empList = empService.getAllEmployeeQuery2(empDto);
		if(empList.isEmpty()) {
			responseHandler = new ResponseHandler(MessageHandler.FAILED);
		}else {
			responseHandler  = new ResponseHandler(empList);
		}
		return new ResponseEntity(responseHandler, HttpStatus.OK);
	}

	@Override
	public ResponseEntity getAllEmployeesQuery3(EmployeeDto empDto) {
		ResponseHandler responseHandler = new ResponseHandler();
		List<EmployeeDto> empList = empService.getAllEmployeeQuery3(empDto);
		if(empList.isEmpty()) {
			responseHandler = new ResponseHandler(MessageHandler.FAILED);
		}else {
			responseHandler  = new ResponseHandler(empList);
		}
		return new ResponseEntity(responseHandler, HttpStatus.OK);
	}
	
	@Override
	public ResponseEntity getAllEmployeesByName() {
		ResponseHandler responseHandler = new ResponseHandler();
		List<EmployeeDto> empList = empService.getAllEmployeeByName();
		if(empList.isEmpty()) {
			responseHandler = new ResponseHandler(MessageHandler.FAILED);
		}else {
			responseHandler  = new ResponseHandler(empList);
		}
		return new ResponseEntity(responseHandler, HttpStatus.OK);
	}

	@Override
	public ResponseEntity getAllEmployeesSpec() {
		ResponseHandler responseHandler = new ResponseHandler();
		List<EmployeeDto> emp = empService.getEmployeeSpec();
		if(emp.equals(null)) {
			responseHandler = new ResponseHandler(MessageHandler.FAILED);
		}else {
			responseHandler = new ResponseHandler(emp);
		}
		return new ResponseEntity(responseHandler, HttpStatus.OK);
	}
}
