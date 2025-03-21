package com.asmae.examenjee.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import java.util.Date;

@Entity
public class Book extends Document {
    @Id
    private String author;
    private String isbn;
    private Date datePublication;

    public Book() {
        super();
    }


    public Book(int id, String title, Date date, String author, String isbn, Date datePublication) {
        super(id, title, date); // Appelle le constructeur de Document
        this.author = author;
        this.isbn = isbn;
        this.datePublication = datePublication;
    }


    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public Date getDatePublication() {
        return datePublication;
    }

    public void setDatePublication(Date datePublication) {
        this.datePublication = datePublication;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + getId() +
                ", title='" + getTitle() + '\'' +
                ", date=" + getDate() +
                ", author='" + author + '\'' +
                ", isbn='" + isbn + '\'' +
                ", datePublication=" + datePublication +
                '}';
    }
}
