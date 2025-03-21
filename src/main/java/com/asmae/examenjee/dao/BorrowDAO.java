package com.asmae.examenjee.dao;

import com.asmae.examenjee.model.Borrow;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import java.util.List;

public class BorrowDAO {

    private EntityManager entityManager;

    public BorrowDAO() {
        this.entityManager = Persistence.createEntityManagerFactory("your-persistence-unit").createEntityManager();
    }


    public void addBorrow(Borrow borrow) {
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            entityManager.persist(borrow);
            transaction.commit();
        } catch (Exception e) {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }


    public Borrow getBorrow(Long id) {
        return entityManager.find(Borrow.class, id);
    }


    public void updateBorrow(Borrow borrow) {
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            entityManager.merge(borrow);
            transaction.commit();
        } catch (Exception e) {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }


    public void deleteBorrow(Long id) {
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            Borrow borrow = entityManager.find(Borrow.class, id);
            if (borrow != null) {
                entityManager.remove(borrow);
            }
            transaction.commit();
        } catch (Exception e) {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }


    public List<Borrow> getAllBorrows() {
        return entityManager.createQuery("SELECT b FROM Borrow b", Borrow.class).getResultList();
    }


    public List<Borrow> getBorrowsByUser(Long userId) {
        return entityManager.createQuery("SELECT b FROM Borrow b WHERE b.user.id = :userId", Borrow.class)
                .setParameter("userId", userId)
                .getResultList();
    }


    public List<Borrow> getBorrowsByDocument(Long documentId) {
        return entityManager.createQuery("SELECT b FROM Borrow b WHERE b.document.id = :documentId", Borrow.class)
                .setParameter("documentId", documentId)
                .getResultList();
    }
}
