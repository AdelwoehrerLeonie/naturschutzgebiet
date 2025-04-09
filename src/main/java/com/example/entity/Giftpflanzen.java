package com.example.entity;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.Entity;

@Entity
public class Giftpflanzen extends PanacheEntity {

    public Long id;

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