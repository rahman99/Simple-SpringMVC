package belajar.spring.mvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import belajar.spring.mvc.dao.DaftarBukuDAO;
import belajar.spring.mvc.entity.DaftarBuku;

public class DaftarBukuServiceImpl implements DaftarBukuService{
	
	@Autowired
	private DaftarBukuDAO daftarBukuDao;

	@Override
	public List<DaftarBuku> getAll() {
		return daftarBukuDao.getAll();
	}
	
	@Override
	public void saveOrUpdate(DaftarBuku daftarBuku) {
		daftarBukuDao.saveOrUpdate(daftarBuku);
	}

	@Override
	public void delete(DaftarBuku daftarBuku) {
		daftarBukuDao.delete(daftarBuku);
	}

	@Override
	public DaftarBuku getRowByID(long id) {
		
		return daftarBukuDao.getRowByID(id);
	}

	@Override
	public List<DaftarBuku> getListBookSearch(String serachKey) {
		return daftarBukuDao.getListBookSearch(serachKey);
	}

}
