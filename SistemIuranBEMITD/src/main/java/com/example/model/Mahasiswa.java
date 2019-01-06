package com.example.model;

import javax.persistence.*;

@Entity
public class Mahasiswa {

	@Id
	private String nim;
	
	@Column(name="nama_mahasiswa")
	private String nama;

	private Long iuran;

	private String status;

	private String id_kelas;

	public String getNim() { return nim; }

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

	public String getId_kelas() {
		return id_kelas;
	}

	public void setId_kelas(String id_kelas) {
		this.id_kelas = id_kelas;
	}
}
