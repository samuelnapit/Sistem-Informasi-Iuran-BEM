package com.example.model;

import javax.persistence.*;

	@Entity
	public class Kelas {

    @Id
    @GeneratedValue
    @Column(name="nama_kelas")
    private String kode;

    private Long iuran;

    public String getKode() {
        return kode;
    }

    public void setKode(String kode) {
        this.kode = kode;
    }

    public Long getIuran() {
        return iuran;
    }

    public void setIuran(Long iuran) {
        this.iuran = iuran;
    }
}
