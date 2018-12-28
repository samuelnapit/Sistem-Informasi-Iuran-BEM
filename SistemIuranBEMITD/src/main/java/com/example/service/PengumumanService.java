package com.example.service;

import com.example.model.*;

import java.util.*;

public interface PengumumanService {

    List<Pengumuman> listPengumuman();

    Pengumuman saveOrUpdatePengumuman(Pengumuman pengumuman);

    Pengumuman getId(Integer id);

    void deletePengumuman(Integer id);
}
