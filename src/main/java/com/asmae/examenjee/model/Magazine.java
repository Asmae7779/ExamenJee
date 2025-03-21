package com.asmae.examenjee.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.util.Date;

@Entity
public class Magazine extends Document {
    @Id
    private String publisher;
    private String issueNumber;
    private Date dateIssue;


    public Magazine() {
        super();
    }


    public Magazine(int id, String title, Date date, String publisher, String issueNumber, Date dateIssue) {
        super(id, title, date); // Appelle le constructeur de Document
        this.publisher = publisher;
        this.issueNumber = issueNumber;
        this.dateIssue = dateIssue;
    }


    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getIssueNumber() {
        return issueNumber;
    }

    public void setIssueNumber(String issueNumber) {
        this.issueNumber = issueNumber;
    }

    public Date getDateIssue() {
        return dateIssue;
    }

    public void setDateIssue(Date dateIssue) {
        this.dateIssue = dateIssue;
    }


    @Override
    public String toString() {
        return "Magazine{" +
                "id=" + getId() +
                ", title='" + getTitle() + '\'' +
                ", date=" + getDate() +
                ", publisher='" + publisher + '\'' +
                ", issueNumber='" + issueNumber + '\'' +
                ", dateIssue=" + dateIssue +
                '}';
    }
}
