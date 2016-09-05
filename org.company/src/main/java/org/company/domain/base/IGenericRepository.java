package org.company.domain.base;

import java.util.List;


public interface IGenericRepository<T> {
	public void save(T entity);
	public List<T> findAll();
	public T findById(int Id);
	public List<T> findByName(String name);
	public T update(T entity);
	public void delete(T entity);
}
