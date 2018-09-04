package com.zycus.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository //alternative for component annotation 
public class CrudRepository {
	
	
	@PersistenceContext
	private EntityManager entityManager;

	@Transactional
	public <T> void create(T entity) {
		// STEP 1: create session factory
	
		entityManager.persist(entity);
	}

	@Transactional
	public <T> void update(T entity) {
		
		entityManager.merge(entity);

		

	}

	@Transactional
	public <T> void delete(Object id, Class<T> clazz) {

		T entity = (T) entityManager.find(clazz, id);
		entityManager.remove(entity);


	}

	public <T> T fetchById(Object id, Class<T> clazz) {

			return (T) entityManager.find(clazz, id);

		
	}

	public <T> List<T> fetchAll(Class<T> clazz) {
		
		String str = "select o from " + clazz.getName() + " as o";
		javax.persistence.Query query = entityManager.createQuery(str); // HQL
		// Hibernate
		// Query
		// Language

		
			return query.getResultList();
		
	}

}
