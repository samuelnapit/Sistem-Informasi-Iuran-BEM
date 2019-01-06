package com.example.dao;

import com.example.model.*;
import com.example.service.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;

import javax.persistence.*;
import java.util.*;

@Service
public class PaymentDao implements PaymentService {

    private EntityManagerFactory emf;

    @Autowired
    public void setEmf(EntityManagerFactory emf) {
        this.emf = emf;
    }

    @Override
    public List<Payment> listPayment() {
        EntityManager em = emf.createEntityManager();
        return em.createQuery("from Payment", Payment.class).getResultList();
    }

    @Override
    public Payment saveOrUpdatePay(Payment payment) {

        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Payment saved = em.merge(payment);
        em.getTransaction().commit();
        return saved;
    }

    @Override
    public Payment getId(Integer id){
        EntityManager em = emf.createEntityManager();
        return em.find(Payment.class, id);
    }

//    @Override
//    public void deletePayment(Integer id) {
//
//        EntityManager em = emf.createEntityManager();
//        em.getTransaction().begin();
//        em.remove(em.find(Payment.class, id));
//        em.getTransaction().commit();
//
//    }
}
