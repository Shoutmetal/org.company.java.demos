package org.company.repository.base;

import java.util.List;
import java.lang.reflect.*;
import org.company.domain.base.IGenericRepository;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


@Transactional
@Repository
public abstract class GenericRepository<T> implements IGenericRepository<T>{

	private final Class<T> _class;
	
	@SuppressWarnings("unchecked")
	public GenericRepository()
	{
		this._class =  (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
	}
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public Session getSession()
	{
		return sessionFactory.getCurrentSession();
	}

	@Override
	public void save(T entity) {
		getSession().save(entity);
	}

	@SuppressWarnings("unchecked")
	public List<T> findAll() {
		Query query = getSession().createQuery("from "+ _class.getName());
		return query.list();
	}
	

	@SuppressWarnings("unchecked")
	@Override
	public T findById(int Id) {
		Criteria criteria = getSession().createCriteria(_class.getName());
		criteria.add(Restrictions.eq("Id", Id));

		return (T) criteria.uniqueResult();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<T> findByName(String name) {
		Criteria criteria = getSession().createCriteria(_class.getName());
		criteria.add(Restrictions.like("Name", "%" + name  + "%"));

		return (List<T>) criteria.list();
	}

	@Override
	public T update(T entity) {
		getSession().update(entity);
		return entity;
	}

	@Override
	public void delete(T entity) {
		getSession().delete(entity);
	}
}
