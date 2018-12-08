package com.example.model;

import javax.persistence.*;

@Entity
public class Mahasiswa {

	@Id
	@GeneratedValue
	private String nim;
	
	@Column(name="nama_mahasiswa")
	private String nama;

	private String status;
	
	private Long iuran;
	
	public String getNim() {
		return nim;
	}
	public void setNim(String nim) {
		this.nim = nim;
	}
	public String getNama() {
		return nama;
	}
	public void setNama(String nama) {
		this.nama = nama;
	}
	public Long getIuran() {
		return iuran;
	}
	public void setIuran(Long iuran) {
		this.iuran = iuran;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
}
