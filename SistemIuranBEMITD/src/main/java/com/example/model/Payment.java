package com.example.model;

import javax.persistence.*;

@Entity
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name="periode_tagihan")
    private String periode;

    private Long tagihan;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPeriode() {
        return periode;
    }

    public void setPeriode(String periode) {
        this.periode = periode;
    }

    public Long getTagihan() {
        return tagihan;
    }

    public void setTagihan(Long tagihan) {
        this.tagihan = tagihan;
    }
}
