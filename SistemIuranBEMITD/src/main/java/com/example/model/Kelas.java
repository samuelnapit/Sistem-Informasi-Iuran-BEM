package com.example.model;

import javax.persistence.*;

	@Entity
	public class Kelas {

    @Id
    @Column(name="nama_kelas")
    private String kode;

    private Long iuran;

    private String status;

    private String prodi;

    public String getProdi() {
            return prodi;
        }

        public void setProdi(String prodi) {
            this.prodi = prodi;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

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
