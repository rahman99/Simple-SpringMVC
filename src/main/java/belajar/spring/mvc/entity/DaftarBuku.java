package belajar.spring.mvc.entity;

/**
 * @author Rahman
 */

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class DaftarBuku {
	
	@Id
	@GeneratedValue
	private long id;
	
	private String judul;
	
	private String pengarang;
	
		
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getJudul() {
		return judul;
	}
	public void setJudul(String judul) {
		this.judul = judul;
	}
	public String getPengarang() {
		return pengarang;
	}
	public void setPengarang(String pengarang) {
		this.pengarang = pengarang;
	}
	
	

}
