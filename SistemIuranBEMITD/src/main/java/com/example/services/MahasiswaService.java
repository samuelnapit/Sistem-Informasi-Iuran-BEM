package com.example.services;

import com.example.model.*;

import java.util.*;

public interface MahasiswaService {

    List<Mahasiswa> listMahasiswa();

    Mahasiswa saveOrUpdate(Mahasiswa mahasiswa);

    Mahasiswa getNim(String nim);
}
