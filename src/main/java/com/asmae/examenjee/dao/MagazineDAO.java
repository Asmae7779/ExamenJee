package com.asmae.examenjee.dao;

import com.asmae.examenjee.model.Magazine;

import jakarta.persistence.*;
import java.util.List;

public class MagazineDAO {
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("examenPU");

    public void addMagazine(Magazine magazine) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            em.persist(magazine);
            tx.commit();
        } finally {
            em.close();
        }
    }

    public Magazine getMagazine(int id) {
        EntityManager em = emf.createEntityManager();
        Magazine magazine = em.find(Magazine.class, id);
        em.close();
        return magazine;
    }

    public void updateMagazine(Magazine magazine) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            em.merge(magazine);
            tx.commit();
        } finally {
            em.close();
        }
    }

    public void deleteMagazine(int id) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            Magazine magazine = em.find(Magazine.class, id);
            if (magazine != null) {
                em.remove(magazine);
            }
            tx.commit();
        } finally {
            em.close();
        }
    }

    public List<Magazine> getAllMagazines() {
        EntityManager em = emf.createEntityManager();
        List<Magazine> magazines = em.createQuery("SELECT m FROM Magazine m", Magazine.class).getResultList();
        em.close();
        return magazines;
    }
}
