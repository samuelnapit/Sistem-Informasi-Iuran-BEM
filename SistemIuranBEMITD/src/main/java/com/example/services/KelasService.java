package com.example.services;

import com.example.model.*;

import java.util.*;

public interface KelasService {

    List<Kelas> listKelas();

    Kelas saveOrUpdateKel(Kelas kelas);

    Kelas getKode(String kode);

    void deteleKelas(String kode);
}
