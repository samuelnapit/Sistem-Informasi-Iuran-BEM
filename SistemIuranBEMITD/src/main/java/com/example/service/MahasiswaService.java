package com.example.service;

import com.example.model.*;

import java.util.*;

public interface MahasiswaService {

    List<Mahasiswa> listMahasiswa();

    Mahasiswa saveOrUpdate(Mahasiswa mahasiswa);

    Mahasiswa getNim(String nim);

    void deleteMahasiswa(String nim);
}
