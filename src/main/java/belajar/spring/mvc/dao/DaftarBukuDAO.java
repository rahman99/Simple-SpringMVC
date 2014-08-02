package belajar.spring.mvc.dao;

import java.util.List;

import belajar.spring.mvc.dao.base.BasisDao;
import belajar.spring.mvc.entity.DaftarBuku;

public interface DaftarBukuDAO extends BasisDao<DaftarBuku>{
	
	public DaftarBuku getRowByID(long id);
	public List<DaftarBuku> getListBookSearch(String serachKey);
}
