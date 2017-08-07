package com.taku.springboot;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

public class MyDataDaoImpl implements MyDataDao<MyData> {
	private static final Long serialVersionUID = 1L;
	
	private EntityManager entityManager;
	
	public MyDataDaoImpl() {
		super();
	}
	
	public MyDataDaoImpl(EntityManager manager) {
		entityManager = manager;
	}
	
	@Override
	public List<MyData> getAll() {
		Query query = entityManager.createQuery("from MyData");
		List<MyData> list = query.getResultList();
		entityManager.close();
		return list;
	}

	@Override
	public MyData findById(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<MyData> findByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

}
