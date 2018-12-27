package com.example.dao;

import com.example.model.*;
import com.example.services.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;

import javax.persistence.*;
import java.util.*;

@Service
public class KelasDao implements KelasService {

    private EntityManagerFactory emf;

    @Autowired
    public void setEmf(EntityManagerFactory emf) {
        this.emf = emf;
    }

    @Override
    public List<Kelas> listKelas() {
        EntityManager em = emf.createEntityManager();
        return em.createQuery("from Kelas", Kelas.class).getResultList();
    }

    @Override
    public Kelas saveOrUpdateKel(Kelas kelas) {

        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Kelas saved = em.merge(kelas);
        em.getTransaction().commit();
        return saved;
    }

    @Override
    public Kelas getKode(String kode){

        EntityManager em = emf.createEntityManager();
        return em.find(Kelas.class, kode);
    }

    @Override
    public void deteleKelas(String kode) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.remove(em.find(Kelas.class,kode));
        em.getTransaction().commit();
    }

}
