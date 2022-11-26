package com.example.testcandoit.model.entity;

import com.example.testcandoit.model.enums.RolName;
import javax.persistence.*;

@Entity
public class Rol {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Enumerated(EnumType.STRING)
    private RolName rolName;


    public Rol(Long id, RolName rolName) {
        this.id = id;
        this.rolName = rolName;
    }

    public Rol() {
        //No-args Constructor
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public RolName getRolName() {
        return rolName;
    }

    public void setRolName(RolName rolName) {
        this.rolName = rolName;
    }
}
