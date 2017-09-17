package com.taku.springboot;

import java.util.List;

import javax.persistence.EntityManager;

public class MsgDataDaoImpl implements MsgDataDao {
	
	private EntityManager entityManager;
		
	public MsgDataDaoImpl() {
		super();
	}
	
	public MsgDataDaoImpl(EntityManager entityManager) {
		super();
		this.entityManager = entityManager;
	}

	@Override
	public List<MyData> getAll() {
		return entityManager.createQuery("from MsgData").getResultList();
	}

	@Override
	public MsgData findById(Long id) {
		return (MsgData) entityManager.createQuery("from MsgData where id = " + id).getSingleResult();
	}

}
