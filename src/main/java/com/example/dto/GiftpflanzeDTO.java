package com.example.dto;

public class GiftpflanzeDTO {
    private Long id;
    private String name;
    private String toxizitaetsstufe;
    private String beschreibung;

    // Getter und Setter
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

    public String getToxizitaetsstufe() {
        return toxizitaetsstufe;
    }

    public void setToxizitaetsstufe(String toxizitaetsstufe) {
        this.toxizitaetsstufe = toxizitaetsstufe;
    }

    public String getBeschreibung() {
        return beschreibung;
    }

    public void setBeschreibung(String beschreibung) {
        this.beschreibung = beschreibung;
    }
}