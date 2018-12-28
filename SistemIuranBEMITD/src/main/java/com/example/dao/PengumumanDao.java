package com.example.dao;

import com.example.model.*;
import com.example.service.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;

import javax.persistence.*;
import java.util.*;

@Service
public class PengumumanDao implements PengumumanService {

    private EntityManagerFactory emf;

    @Autowired
    public void setEmf(EntityManagerFactory emf) {
        this.emf = emf;
    }

    @Override
    public List<Pengumuman> listPengumuman() {
        EntityManager em = emf.createEntityManager();
        return em.createQuery("from Pengumuman", Pengumuman.class).getResultList();
    }

    @Override
    public Pengumuman saveOrUpdatePengumuman(Pengumuman pengumuman) {

        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Pengumuman saved = em.merge(pengumuman);
        em.getTransaction().commit();
        return saved;
    }

    @Override
    public Pengumuman getId(Integer id){

        EntityManager em = emf.createEntityManager();
        return em.find(Pengumuman.class, id);
    }

    @Override
    public void deletePengumuman(Integer id) {

        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.remove(em.find(Pengumuman.class, id));
        em.getTransaction().commit();

    }
}
