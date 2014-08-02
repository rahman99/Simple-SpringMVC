package belajar.spring.mvc.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import belajar.spring.mvc.dao.base.BasisDaoImpl;
import belajar.spring.mvc.entity.DaftarBuku;

@Repository
@Transactional
public class DaftarBukuDAOImpl extends BasisDaoImpl<DaftarBuku> implements DaftarBukuDAO {
	
	@Autowired
	private SessionFactory sessionFactory;
	private Session session = null;

	@Override
	public DaftarBuku getRowByID(long id) {
		Session session = sessionFactory.openSession();
		DaftarBuku daftarBuku = (DaftarBuku) session.load(DaftarBuku.class, id);
		return daftarBuku;
	}

	@SuppressWarnings({ "unchecked" })
	@Override
	public List<DaftarBuku> getListBookSearch(String searchKey) {
		try {
			session = sessionFactory.openSession();
			
			Criteria c = session.createCriteria(DaftarBuku.class)
					.add(Restrictions.or
							(	Restrictions.like("judul", "%"+searchKey+"%"), 
								Restrictions.like("pengarang", "%"+searchKey+"%")
						    )
						);
			
			
			return c.list();		
			
		} catch (Exception ex) {
			String stackTrace = ex.getMessage();
			System.out.print("Error : "+stackTrace);
		} finally {
			session.close();
		}
		return null;
	}

}
