package com.example.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Giftpflanze {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private int toxizitaetsstufe;
    private String beschreibung;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBeschreibung() {
        return beschreibung;
    }

    public void setBeschreibung(String beschreibung) {
        this.beschreibung = beschreibung;
    }

    public String getToxizitaetsstufe() {
        return String.valueOf(toxizitaetsstufe);
    }

    public void setToxizitaetsstufe(int toxizitaetsstufe) {
        this.toxizitaetsstufe = toxizitaetsstufe;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}