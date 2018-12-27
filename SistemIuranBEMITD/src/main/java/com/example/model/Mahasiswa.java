package com.example.model;

import javax.persistence.*;

@Entity
public class Mahasiswa {

	@Id
	private String nim;
	
	@Column(name="nama_mahasiswa")
	private String nama;

	private String jenis_kelamin;

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

	public String getJenis_kelamin() {
		return jenis_kelamin;
	}

	public void setJenis_kelamin(String jenis_kelamin) {
		this.jenis_kelamin = jenis_kelamin;
	}
}
