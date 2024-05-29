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

import java.util.List;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;

import org.hibernate.Hibernate;
import org.hibernate.proxy.HibernateProxy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

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
		
		//predicates.add(criteriaBuilder.or(criteriaBuilder.equal(root.get(fieldName), criteriaBuilder.equal(root.get(fieldName)));
		
		predicates.add(criteriaBuilder.or(criteriaBuilder.equal(root.get(fieldName), searchTerm), 
				criteriaBuilder.equal(root.get(fieldName), searchTerm)));
		
		predicates.add(criteriaBuilder.equal(root.get(fieldName), searchTerm));
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