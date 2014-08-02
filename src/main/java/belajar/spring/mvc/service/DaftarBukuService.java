package belajar.spring.mvc.service;

import java.util.List;

import belajar.spring.mvc.entity.DaftarBuku;

public interface DaftarBukuService{

	public List<DaftarBuku> getAll();
	public void saveOrUpdate(DaftarBuku daftarBuku);
	public void delete(DaftarBuku daftarBuku);
	
	public DaftarBuku getRowByID(long id);
	public List<DaftarBuku> getListBookSearch(String serachKey);
}
