package com.asmae.examenjee.dao;

import com.asmae.examenjee.model.Document;

import jakarta.persistence.*;
import java.util.List;

public class DocumentDAO {

    private EntityManagerFactory entityManagerFactory;
    private EntityManager entityManager;

    public DocumentDAO() {
        // Initialisation de l'EntityManagerFactory et EntityManager
        this.entityManagerFactory = Persistence.createEntityManagerFactory("yourPersistenceUnit");
        this.entityManager = entityManagerFactory.createEntityManager();
    }


    public void addDocument(Document document) {
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            entityManager.persist(document);
            transaction.commit();
        } catch (RuntimeException e) {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            throw e;
        }
    }


    public void updateDocument(Document document) {
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            entityManager.merge(document);
            transaction.commit();
        } catch (RuntimeException e) {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            throw e;
        }
    }

    // Méthode pour supprimer un document
    public void deleteDocument(int documentId) {
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            Document document = entityManager.find(Document.class, documentId);
            if (document != null) {
                entityManager.remove(document);
            }
            transaction.commit();
        } catch (RuntimeException e) {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            throw e;
        }
    }


    public List<Document> getAllDocuments() {
        TypedQuery<Document> query = entityManager.createQuery("SELECT d FROM Document d", Document.class);
        return query.getResultList();
    }


    public Document getDocumentById(int documentId) {
        return entityManager.find(Document.class, documentId);
    }


    public void close() {
        if (entityManager != null) {
            entityManager.close();
        }
        if (entityManagerFactory != null) {
            entityManagerFactory.close();
        }
    }
}
