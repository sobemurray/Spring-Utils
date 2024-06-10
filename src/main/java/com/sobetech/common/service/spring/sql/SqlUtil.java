/**
 *  Created by Sobetech Holdings LLC
 *
 *  Copyright © 2024 Sobetech Holdings LLC, All Rights Reserved
 *
 *  This software is supplied under the terms of a license agreement or
 *  nondisclosure agreement with Team Focus / Peak6, or one of its
 *  affiliates, and may not be used, disseminated, or distributed except
 *  in accordance with the terms of that agreement.
 *
 */
package com.sobetech.common.service.spring.sql;

import java.lang.reflect.Field;
import java.util.List;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;

import org.hibernate.Hibernate;
import org.hibernate.proxy.HibernateProxy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.sobetech.common.exception.ApiRuntimeException;
import com.sobetech.common.model.annotation.sql.EqualsCriteria;
import com.sobetech.common.model.annotation.sql.GreaterThanCriteria;
import com.sobetech.common.model.annotation.sql.GreaterThanEqualsCriteria;
import com.sobetech.common.model.annotation.sql.LessThanCriteria;
import com.sobetech.common.model.annotation.sql.LessThanEqualsCriteria;
import com.sobetech.common.model.annotation.sql.LikeCriteria;
import com.sobetech.common.model.sql.SearchCriteria;

/**
 * A utility service to assist in SQL and other database operations
 *
 * @author John Murray
 *
 * @since May 29, 2024
 *
 */
@Service
public class SqlUtil
{
	protected final Logger LOG = LoggerFactory.getLogger(this.getClass());	
	
	/**
	 * Convert an entity object that is currently in the Hibernate proxy state to be cast back to it's original
	 * form
	 * 
	 * @param <P> The type of entity that is desired
	 * @param proxiedEntity The entity to convert
	 * @return The entity converted back to it's original form
	 */
	@SuppressWarnings("unchecked")
	public <P> P initializeAndUnproxy(P proxiedEntity)
	{
		if(proxiedEntity == null)
		{
			return null;
		}
		
		Hibernate.initialize(proxiedEntity);
		if(proxiedEntity instanceof HibernateProxy)
		{
			proxiedEntity = (P) ((HibernateProxy) proxiedEntity).getHibernateLazyInitializer().getImplementation();
		}
		
		return proxiedEntity;
	}

	/**
	 * Process and entire Search Criteria object and add Predicates for each of the attributes that are not null 
	 * into the search
	 * 
	 * @param <P> The type of object being searched
	 * @param predicates The current list of predicates
	 * @param criteriaBuilder The criteria builder used to make Predicates
	 * @param root The Root of the Specification
	 * @param searchCriteria The SearchCriteria to build the predicates from
	 * @throws IllegalArgumentException If any reflection issues occur
	 * @throws IllegalAccessException If any reflection issues occur
	 */
	public <P> void addPredicates(List<Predicate> predicates, CriteriaBuilder criteriaBuilder, Root<P> root, 
			SearchCriteria searchCriteria) throws IllegalArgumentException, IllegalAccessException
	{
		Field[] searchCriteriaFields = searchCriteria.getClass().getDeclaredFields();

        for (Field searchCriteriaField : searchCriteriaFields) 
        {
        	searchCriteriaField.setAccessible(true);
        	
        	Object criteriaValue = searchCriteriaField.get(searchCriteria);
        	
        	if(criteriaValue == null)
        	{
        		continue;
        	}

        	// This is VERY Clunky. Java 17 switch might make this better
        	
        	// EQUALS
        	if(searchCriteriaField.isAnnotationPresent(EqualsCriteria.class))
        	{
        		EqualsCriteria equalsCriteria = searchCriteriaField.getAnnotation(EqualsCriteria.class);
        		
        		String searchFieldName = equalsCriteria.fieldName();
        		
        		if(searchFieldName.isBlank())
        		{
        			searchFieldName = searchCriteriaField.getName();
        		}
        		
        		predicates.add(criteriaBuilder.equal(root.get(searchFieldName), criteriaValue));
        	}
        	
        	// iLIKE
        	if(searchCriteriaField.isAnnotationPresent(LikeCriteria.class))
        	{
        		LikeCriteria likeCriteria = searchCriteriaField.getAnnotation(LikeCriteria.class);
        		
        		String searchFieldName = likeCriteria.fieldName();
        		
        		if(searchFieldName.isBlank())
        		{
        			searchFieldName = searchCriteriaField.getName();
        		}
        		
        		String likeTerm = "%" + criteriaValue.toString().toLowerCase() + "%";
        		
        		predicates.add(criteriaBuilder.like(criteriaBuilder.lower(root.get(searchFieldName)), likeTerm));

        	}
        	
        	// >
        	if(searchCriteriaField.isAnnotationPresent(GreaterThanCriteria.class))
        	{
        		Number numberCriteriaValue = null;
        		
        		if(criteriaValue instanceof Number)
        		{
        			numberCriteriaValue = (Number)criteriaValue;
        		}
        		else
        		{
        			throw new ApiRuntimeException("Expected a Number from " + searchCriteriaField.getName());
        		}
        		
        		GreaterThanCriteria greaterThanCriteria = searchCriteriaField.getAnnotation(GreaterThanCriteria.class);
        		
        		String searchFieldName = greaterThanCriteria.fieldName();
        		
        		if(searchFieldName.isBlank())
        		{
        			searchFieldName = searchCriteriaField.getName();
        		}
        		
        		predicates.add(criteriaBuilder.gt(root.get(searchFieldName), numberCriteriaValue));
        	}
        	
        	// >=
        	if(searchCriteriaField.isAnnotationPresent(GreaterThanEqualsCriteria.class))
        	{
        		Number numberCriteriaValue = null;
        		
        		if(criteriaValue instanceof Number)
        		{
        			numberCriteriaValue = (Number)criteriaValue;
        		}
        		else
        		{
        			throw new ApiRuntimeException("Expected a Number from " + searchCriteriaField.getName());
        		}
        		
        		GreaterThanEqualsCriteria greaterThanEqualsCriteria = searchCriteriaField.getAnnotation(GreaterThanEqualsCriteria.class);
        		
        		String searchFieldName = greaterThanEqualsCriteria.fieldName();
        		
        		if(searchFieldName.isBlank())
        		{
        			searchFieldName = searchCriteriaField.getName();
        		}
        		
        		predicates.add(criteriaBuilder.gt(root.get(searchFieldName), numberCriteriaValue));
        	}
        	
        	// <
        	if(searchCriteriaField.isAnnotationPresent(LessThanCriteria.class))
        	{
        		Number numberCriteriaValue = null;
        		
        		if(criteriaValue instanceof Number)
        		{
        			numberCriteriaValue = (Number)criteriaValue;
        		}
        		else
        		{
        			throw new ApiRuntimeException("Expected a Number from " + searchCriteriaField.getName());
        		}
        		
        		LessThanCriteria lessThanCriteria = searchCriteriaField.getAnnotation(LessThanCriteria.class);
        		
        		String searchFieldName = lessThanCriteria.fieldName();
        		
        		if(searchFieldName.isBlank())
        		{
        			searchFieldName = searchCriteriaField.getName();
        		}
        		
        		predicates.add(criteriaBuilder.gt(root.get(searchFieldName), numberCriteriaValue));
        	}
        	
        	// <=
        	if(searchCriteriaField.isAnnotationPresent(LessThanEqualsCriteria.class))
        	{
        		Number numberCriteriaValue = null;
        		
        		if(criteriaValue instanceof Number)
        		{
        			numberCriteriaValue = (Number)criteriaValue;
        		}
        		else
        		{
        			throw new ApiRuntimeException("Expected a Number from " + searchCriteriaField.getName());
        		}
        		
        		LessThanEqualsCriteria lessThanEqualsCriteria = searchCriteriaField.getAnnotation(LessThanEqualsCriteria.class);
        		
        		String searchFieldName = lessThanEqualsCriteria.fieldName();
        		
        		if(searchFieldName.isBlank())
        		{
        			searchFieldName = searchCriteriaField.getName();
        		}
        		
        		predicates.add(criteriaBuilder.gt(root.get(searchFieldName), numberCriteriaValue));
        	}
        }
	}

	/**
	 * Add a new Predicate to the current list of Predicate objects
	 * 
	 * @param <P> The type of object being searched
	 * @param predicates The current list of predicates
	 * @param criteriaBuilder The criteria builder used to make Predicates
	 * @param root The Root of the Specification
	 * @param fieldName The name of the field to search on
	 * @param searchTerm The value to search for
	 */
	public <P> void addPredicateIfNotNull(List<Predicate> predicates, CriteriaBuilder criteriaBuilder, Root<P> root, 
			String fieldName, Object searchTerm)
	{
		if(searchTerm == null)
		{
			return;
		}
		
		predicates.add(criteriaBuilder.equal(root.get(fieldName), searchTerm));
	}
	
	/**
	 * Add a new iLike Predicate to the current list of Predicate objects
	 * 
	 * @param <P> The type of object being searched
	 * @param predicates The current list of predicates
	 * @param criteriaBuilder The criteria builder used to make Predicates
	 * @param root The Root of the Specification
	 * @param fieldName The name of the field to search on
	 * @param searchTerm The value to search for
	 */
	public <P> void addLikePredicateIfNotNull(List<Predicate> predicates, CriteriaBuilder criteriaBuilder, Root<P> root, 
			String fieldName, Object searchTerm)
	{
		if(searchTerm == null)
		{
			return;
		}
		
		String likeTerm = "%" + searchTerm.toString().toLowerCase() + "%";
		
		predicates.add(criteriaBuilder.like(criteriaBuilder.lower(root.get(fieldName)), likeTerm));
	}
	
	/**
	 * Add a new OR Predicate to the current list of Predicate objects
	 * 
	 * @param <P> The type of object being searched
	 * @param predicates The current list of predicates
	 * @param criteriaBuilder The criteria builder used to make Predicates
	 * @param root The Root of the Specification
	 * @param fieldName1 The name of the first field to search on as part of the OR
	 * @param fieldName2 The name of the second field to search on as part of the OR
	 * @param searchTerm The value to search for in both parts of the OR
	 */
	public <P> void addOrPredicateIfNotNull(List<Predicate> predicates, CriteriaBuilder criteriaBuilder, Root<P> root, 
			String fieldName1, String fieldName2, Object searchTerm)
	{
		addOrPredicateIfNotNull(predicates, criteriaBuilder, root, fieldName1, fieldName2, searchTerm, searchTerm);
	}
	
	/**
	 * Add a new OR Predicate to the current list of Predicate objects
	 * 
	 * @param <P> The type of object being searched
	 * @param predicates The current list of predicates
	 * @param criteriaBuilder The criteria builder used to make Predicates
	 * @param root The Root of the Specification
	 * @param fieldName1 The name of the first field to search on as part of the OR
	 * @param fieldName2 The name of the second field to search on as part of the OR
	 * @param searchTerm1 The first value to search for in the first part of the OR
	 * @param searchTerm2 The second value to search for in the second part of the OR
	 */
	public <P> void addOrPredicateIfNotNull(List<Predicate> predicates, CriteriaBuilder criteriaBuilder, Root<P> root, 
			String fieldName1, String fieldName2, Object searchTerm1, Object searchTerm2)
	{
		if(searchTerm1 == null || searchTerm2 == null)
		{
			return;
		}

		predicates.add(criteriaBuilder.or(criteriaBuilder.equal(root.get(fieldName1), searchTerm1), 
				criteriaBuilder.equal(root.get(fieldName2), searchTerm2)));
	}		
}