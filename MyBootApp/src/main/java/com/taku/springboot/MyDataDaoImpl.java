package com.taku.springboot;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.criteria.*;

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
		List<MyData> list = null;
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		CriteriaQuery<MyData> query = builder.createQuery(MyData.class);
		Root<MyData> root = query.from(MyData.class);
		query.select(root).orderBy(builder.asc(root.get("age")));
		list = (List<MyData>)entityManager.createQuery(query).getResultList();
		return list;
	}

/*	@Override
	public List<MyData> getAll() {
		Query query = entityManager.createQuery("from MyData");
		List<MyData> list = query.getResultList();
		entityManager.close();
		return list;
	}*/
	
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

	@Override
	public List<MyData> find(String fstr) {
		List<MyData> result = null;
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		CriteriaQuery<MyData> query = builder.createQuery(MyData.class);
		Root<MyData> root = query.from(MyData.class);
		query.select(root).where(builder.equal(root.get("name"), fstr));
		result = (List<MyData>)entityManager.createQuery(query).getResultList();
		return result;
	}
	
/*	@Override
	public List<MyData> find(String fstr) {
		List<MyData> result = null;
		Long fid = 0L;
		try {
			fid = Long.parseLong(fstr);
		} catch (NumberFormatException e) {
			//e.printStackTrace();
		}
		Query query = entityManager.createNamedQuery("findByAge").
				setParameter("fname", "%" + fstr + "%");
		result = query.getResultList();
		return result;
	}*/

	@Override
	public List<MyData> findByAge(int min , int max) {
		List<MyData> result = null;
		Query query = entityManager.createNamedQuery("findByAge").
				setParameter("min", min)
				.setParameter("max", max);
		result = query.getResultList();
		return result;
	}

}
