package com.example.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Kelas {

    @Id
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
