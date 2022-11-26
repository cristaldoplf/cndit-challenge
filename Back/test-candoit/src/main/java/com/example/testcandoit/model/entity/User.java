package com.example.testcandoit.model.entity;

import javax.persistence.*;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String email;
    private String adress;
    private String password;
    @ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    private Rol rol;

    public User(Integer id, String name, String email, String adress, String password, Rol rol) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.adress = adress;
        this.password = password;
        this.rol = rol;
    }

    public User() {
        //No-args Constructor
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }
}
