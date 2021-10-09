package com.spec.spec.DAO;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.spec.spec.model.Employee;

public interface EmployeeDAO extends JpaRepository<Employee, Integer>, JpaSpecificationExecutor<Employee>{
	
	@Query("SELECT e FROM Employee e WHERE e.id = :id ") 
	public List<Employee> findAllQuery(@Param("id") int id);

	@Query("SELECT e FROM Employee e WHERE e.id = :id ") 
	public List<Employee> findAllQuery1(int id);
	
	@Query("SELECT e FROM Employee e WHERE e.id = :id ") 
	public List<Employee> findAllQuery2(@Param("id") int id);
	
	@Query("SELECT e FROM Employee e WHERE e.id = :#{#emp.id}") 
	public List<Employee> findAllQuery3(@Param("emp") Employee emp);
	
	public List<Employee> findAllByFirstName(String firstName);
}
