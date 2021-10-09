package com.spec.spec.DAOImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

import com.spec.spec.DAO.EmployeeDAO;
import com.spec.spec.dto.EmployeeDto;
import com.spec.spec.model.Employee;
import com.spec.spec.utils.GeneralUtils;
import com.spec.spec.utils.QuerySpecification;
import com.spec.spec.utils.Specifications;

@Component
public class EmployeeHandler {
	@Autowired
	Specifications specifications;
	
	@Autowired
	GeneralUtils generalUtils;
	
	@Autowired
	EmployeeDAO employeeDAO;
	
	@Autowired
	QuerySpecification querySpecification;
	
	public List<Employee> findAllBySpec(String firstName, int id){
		List<EmployeeDto> empDtoList = new ArrayList<EmployeeDto>();
		List<Employee> empList = new ArrayList<Employee>();

		List<Specifications> specifications = new ArrayList<Specifications>();
		
		employeeDAO.findAll(Specification.where((root, query, builder)->{
			if(id != 0) {
				specifications.add(new Specifications("id", id , "=", root, "or"));
			}
			if(firstName != null) {
				specifications.add(new Specifications("firstName", "%"+firstName , "%", root, "or"));
			}
			return querySpecification.makeBuilder(querySpecification.search(specifications, builder), builder);
		})).forEach((emp)->{
			empList.add(emp);
		});
		
		return empList;		
	}
}
