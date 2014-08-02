package belajar.spring.mvc.dao.base;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class BasisDaoImpl<T> implements BasisDao<T>{
	
	@Autowired
	private SessionFactory sessionFactory;
	

	protected Session session = null;
	
	private Class<T> genericType = null;
	
	
	
	@SuppressWarnings("unchecked")
	public Class<T> getType() {
		
		if(genericType==null){
			ParameterizedType type = (ParameterizedType) this.getClass().getGenericSuperclass();
			genericType = (Class<T>) type.getActualTypeArguments()[0];
		}
		return genericType;
	}


	@SuppressWarnings("unchecked")
	public List<T> getAll() {
		try {
			session = sessionFactory.openSession();
			Criteria c = (Criteria) session.createCriteria(getType());
			return c.list();
			//return getHibernateTemplate().loadAll(getType());
		} catch (Exception e) {
			System.out.println("error message getAll : "+e.getMessage());
		} finally {
			session.close();
		}
		
		return null;		
	}
	
	public void saveOrUpdate(T entity){
		try {
			session = sessionFactory.openSession();
			session.saveOrUpdate(entity);
			session.flush(); 
			
		} catch (Exception e) {
			System.out.println("error message : "+e.getMessage());
		} finally {
			session.close();
		}
	}
	
	public void delete(T entity){
		try {
			session = sessionFactory.openSession();
			session.delete(entity);
			session.flush(); 
			
		} catch (Exception e) {
			System.out.println("error message "+e.getMessage());
		} finally {
			session.close();
		}
	}
	
	
	
}
