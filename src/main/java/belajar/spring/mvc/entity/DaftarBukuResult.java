package belajar.spring.mvc.entity;

import java.util.List;

public class DaftarBukuResult {
	
	private String searchKey;
	private List<DaftarBuku> daftarBukuList;
	
	public String getSearchKey() {
		return searchKey;
	}
	public void setSearchKey(String searchKey) {
		this.searchKey = searchKey;
	}
	public List<DaftarBuku> getDaftarBukuList() {
		return daftarBukuList;
	}
	public void setDaftarBukuList(List<DaftarBuku> daftarBukuList) {
		this.daftarBukuList = daftarBukuList;
	}
}
