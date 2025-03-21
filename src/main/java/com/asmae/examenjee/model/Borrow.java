package com.asmae.examenjee.model;

import jakarta.persistence.*;
import java.util.Date;

@Entity
public class Borrow {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "document_id", nullable = false)
    private Document document;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Temporal(TemporalType.DATE)
    private Date dateBorrow;

    @Temporal(TemporalType.DATE)
    private Date returnDate;


    public Borrow() {
    }

    public Borrow(Document document, User user, Date dateBorrow, Date returnDate) {
        this.document = document;
        this.user = user;
        this.dateBorrow = dateBorrow;
        this.returnDate = returnDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Document getDocument() {
        return document;
    }

    public void setDocument(Document document) {
        this.document = document;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Date getDateBorrow() {
        return dateBorrow;
    }

    public void setDateBorrow(Date dateBorrow) {
        this.dateBorrow = dateBorrow;
    }

    public Date getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(Date returnDate) {
        this.returnDate = returnDate;
    }

    @Override
    public String toString() {
        return "Borrow{" +
                "id=" + id +
                ", document=" + document.getTitle() +
                ", user=" + user.getName() +
                ", dateBorrow=" + dateBorrow +
                ", returnDate=" + returnDate +
                '}';
    }
}
