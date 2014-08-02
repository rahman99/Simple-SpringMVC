package belajar.spring.mvc.dao.base;

import java.util.List;

public interface BasisDao<T> {

	public List<T> getAll();
	public void saveOrUpdate(T entity);
	public void delete(T entity);
}
