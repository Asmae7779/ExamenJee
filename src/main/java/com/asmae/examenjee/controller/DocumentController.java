package com.asmae.examenjee.controller;

import com.asmae.examenjee.dao.BookDAO;
import com.asmae.examenjee.dao.MagazineDAO;
import com.asmae.examenjee.dao.UserDAO;
import com.asmae.examenjee.dao.DocumentDAO;
import com.asmae.examenjee.dao.BorrowDAO;
import com.asmae.examenjee.model.*;

import java.util.List;

public class DocumentController {
    private BookDAO bookDAO = new BookDAO();
    private MagazineDAO magazineDAO = new MagazineDAO();
    private UserDAO userDAO = new UserDAO();
    private DocumentDAO documentDAO = new DocumentDAO();
    private BorrowDAO borrowDAO = new BorrowDAO();

    // Ajouter un document (livre ou magazine)
    public void addDocument(Document document) {
        if (document instanceof Book) {
            bookDAO.addBook((Book) document);
        } else if (document instanceof Magazine) {
            magazineDAO.addMagazine((Magazine) document);
        } else {
            documentDAO.addDocument(document);
        }
    }

    // Supprimer un document par ID
    public void removeDocument(int documentId) {
        documentDAO.deleteDocument(documentId);
    }

    // Récupérer un document par ID
    public Document getDocumentById(int documentId) {
        return documentDAO.getDocumentById(documentId);
    }

    // Lister tous les documents disponibles
    public List<Document> listDocuments() {
        return documentDAO.getAllDocuments();
    }

    // Modifier un document
    public void updateDocument(Document document) {
        documentDAO.updateDocument(document);
    }

    // Emprunter un document
    public void borrowDocument(long userId, int documentId) {
        User user = userDAO.getUser(userId);
        Document document = documentDAO.getDocumentById(documentId);

        if (user != null && document != null) {
            Borrow borrow = new Borrow();
            borrow.setUser(user);
            borrow.setDocument(document);
            borrowDAO.addBorrow(borrow);
        }
    }

    // Rendre un document
    public void returnDocument(Long borrowId) {
        borrowDAO.deleteBorrow(borrowId);
    }

    // Lister tous les emprunts
    public List<Borrow> listBorrows() {
        return borrowDAO.getAllBorrows();
    }
}
