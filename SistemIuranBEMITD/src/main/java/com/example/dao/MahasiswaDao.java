package com.example.dao;

import com.example.service.*;
import com.example.model.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;

import javax.persistence.*;
import java.util.List;

@Service
public class MahasiswaDao implements MahasiswaService {

    private EntityManagerFactory emf;

    @Autowired
    public void setEmf(EntityManagerFactory emf) {
        this.emf = emf;
    }

    @Override
    public List<Mahasiswa> listMahasiswa() {
        EntityManager em = emf.createEntityManager();
        return em.createQuery("from Mahasiswa", Mahasiswa.class).getResultList();
    }

    @Override
    public Mahasiswa saveOrUpdate(Mahasiswa mahasiswa) {

        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Mahasiswa saved = em.merge(mahasiswa);
        em.getTransaction().commit();
        return saved;
    }

    @Override
    public Mahasiswa getNim(String nim){

        EntityManager em = emf.createEntityManager();
        return em.find(Mahasiswa.class, nim);
    }

    @Override
    public void deleteMahasiswa(String nim) {

        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.remove(em.find(Mahasiswa.class, nim));
        em.getTransaction().commit();

    }
}
