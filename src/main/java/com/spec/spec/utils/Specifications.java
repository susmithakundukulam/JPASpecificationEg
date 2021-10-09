package com.spec.spec.utils;

import javax.persistence.criteria.Join;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Component;

@Component
public class Specifications {
	private String fieldName;
	private Object fieldValue;
	private String operator;
	private Root root;
	private Join join;
	private String condition;
	
	public Specifications() {}
	public Specifications(String fieldName, Object fieldValue, String operator, Root root, String condition) {
		this.fieldName = fieldName;
		this.fieldValue = fieldValue;
		this.operator = operator;
		this.root = root;
		this.condition = condition;
	}
	
	public Specifications(String fieldName, Object fieldValue, String operator, Join join) {
		this.fieldName = fieldName;
		this.fieldValue = fieldValue;
		this.operator = operator;
		this.join = join;
	}
	
	public Specifications(String fieldName, Object fieldValue, String operator, Root root) {
		this.fieldName = fieldName;
		this.fieldValue = fieldValue;
		this.operator = operator;
		this.root = root;
	}
	
	public Specifications(String fieldName, Object fieldValue, Join join) {
		this.fieldName = fieldName;
		this.fieldValue = fieldValue;
		this.join = join;
	}
	public String getFieldName() {
		return fieldName;
	}
	
	public void setFieldName(String fieldName) {
		this.fieldName = fieldName;
	}
	
	public Object getFieldValue() {
		return fieldValue;
	}
	
	public void setFieldValue(Object fieldValue) {
		this.fieldValue = fieldValue;
	}
	
	public String getOperator() {
		return operator;
	}
	
	public void setOperator(String operator) {
		this.operator = operator;
	}
	
	public Root getRoot() {
		return root;
	}
	
	public void setRoot(Root root) {
		this.root = root;
	}
	public Join getJoin() {
		return join;
	}
	public void setJoin(Join join) {
		this.join = join;
	}
	public String getCondition() {
		return condition;
	}
	public void setCondition(String condition) {
		this.condition = condition;
	}
	
}
