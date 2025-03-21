package com.asmae.examenjee.model;


import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

import java.util.HashSet;
import java.util.Set;

@Entity
public class User {
    @Id
    private Long id;
    private String name;
    private String mail;
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private Set<Borrow> borrows = new HashSet<>();


    public User() {
    }


    public User(Long id, String name, String mail) {
        this.id = id;
        this.name = name;
        this.mail = mail;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }


    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", mail='" + mail + '\'' +
                '}';
    }
}
