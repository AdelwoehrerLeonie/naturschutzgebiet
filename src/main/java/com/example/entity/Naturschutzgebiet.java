package com.example.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Naturschutzgebiet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String ort;

    @OneToMany(mappedBy = "naturschutzgebiet", cascade = CascadeType.ALL)
    private List<Tier> tiere;


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

    public String getOrt() {
        return ort;
    }

    public void setOrt(String ort) {
        this.ort = ort;
    }

    public List<Tier> getTiere() {
        return tiere;
    }

    public void setTiere(List<Tier> tiere) {
        this.tiere = tiere;
    }
}
