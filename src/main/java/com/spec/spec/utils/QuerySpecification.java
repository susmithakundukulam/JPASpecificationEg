package com.spec.spec.utils;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Component;

@Component
public class QuerySpecification <T extends Serializable> {
	  public <T1, T2> Join<T1, T2> makeJoin(Root<T> root, T1 val1, T2 val2, String joinFiled, JoinType joinType) {
	        Join<T1, T2> addresses = root.join(joinFiled, joinType);
	        return addresses;

	  }
	   public <T1, T2> Join<T1, T2> makeJoin(Join<T, T> join, T1 val1, T2 val2, String joinFiled, JoinType joinType) {
	        Join<T1, T2> addresses = join.join(joinFiled, joinType);
	        return addresses;

	  }
	   public Predicate makeBuilder(HashMap<String, Predicate> hashMap, CriteriaBuilder builder) {

	        if (hashMap.containsKey("OR") && hashMap.containsKey("AND")) {
	            return builder.and(hashMap.get("OR"), hashMap.get("AND"));
	        } else if (hashMap.containsKey("OR") && !hashMap.containsKey("AND")) {
	            return builder.and(hashMap.get("OR"));
	        } else if (!hashMap.containsKey("OR") && hashMap.containsKey("AND")) {
	            return builder.and(hashMap.get("AND"));
	        } else {
	            return builder.and();
	        }

	    }
	   
	   public <T> HashMap<String, Predicate> search(List<Specifications> specificationses, CriteriaBuilder builder) {
		  HashMap<String, Predicate> hashMap = new HashMap<>();
		  List<Specifications> specificationsOr = new ArrayList<>();
		  List<Specifications> specificationsAnd = new ArrayList<>();

		  specificationses.forEach(spec -> {
			   switch (spec.getCondition()) {
				   case "and":
				   specificationsAnd.add(spec);
		
				   break;
				   case "or":
				   specificationsOr.add(spec);
		
				   break;
			   }

		   });

		   if (!specificationsAnd.isEmpty()) {
		   hashMap.put("AND", writeJRootsAndCondition(specificationsAnd, builder));
		   }
		   if (!specificationsOr.isEmpty()) {
		   hashMap.put("OR", writeJRootsORCondition(specificationsOr, builder));
		   }

		   return hashMap;

	 }
	   
	   public <T, S> Predicate writeJRootsAndCondition(List<Specifications> specificationsList, CriteriaBuilder builder) {

	        List<Predicate> predicates = new ArrayList<>();
	        if (specificationsList != null && specificationsList.size() > 0) {

	            specificationsList.forEach(data -> {

	                predicates.add(writeRootCondition(data, builder));
	            });

	            return builder.and(predicates.toArray(new Predicate[0]));
	        } else {
	            return builder.and();
	        }

	   }
	  
	   public <T, S> Predicate writeJRootsORCondition(List<Specifications> specificationsList, CriteriaBuilder builder) {

	        List<Predicate> predicates = new ArrayList<>();
	        if (specificationsList != null && specificationsList.size() > 0) {

	            specificationsList.forEach(data -> {

	                predicates.add(writeRootCondition(data, builder));
	            });

	            return builder.or(predicates.toArray(new Predicate[0]));
	        }
	        return builder.or();
	    }
	   
	   private <T, S> Predicate writeRootCondition(Specifications data, CriteriaBuilder builder) {

	        switch (data.getOperator()) {
	            case "=": {
	                return builder.equal(data.getRoot().get(data.getFieldName()), data.getFieldValue());
	            }

	            case "!=": {
	                return builder.notEqual(data.getRoot().get(data.getFieldName()), data.getFieldValue());
	            }
	            case ">=": {
	                return builder.greaterThanOrEqualTo(data.getRoot().get(data.getFieldName()), data.getFieldValue().toString());
	            }
	            case "<=": {
	                return builder.lessThanOrEqualTo(data.getRoot().get(data.getFieldName()), data.getFieldValue().toString());
	            }
	            case ">": {
	                return builder.greaterThan(data.getRoot().get(data.getFieldName()), data.getFieldValue().toString());
	            }
	            case "<": {
	                return builder.lessThan(data.getRoot().get(data.getFieldName()), data.getFieldValue().toString());
	            }
	            case "": {
	                return builder.isNull(data.getRoot().get(data.getFieldName()));
	            }
	            case "!": {
	                return builder.isNotNull(data.getRoot().get(data.getFieldName()));
	            }
	            case ">=<=": {
	                String[] between = data.getFieldValue().toString().split(":");
	                return builder.between(data.getRoot().get(data.getFieldName()), between[0], between[1]);
	            }
	            case "%": {
	                return builder.like(data.getRoot().get(data.getFieldName()), data.getFieldValue() + "%");
	            }
	        }
	        return builder.and();
	    }

}
