package com.example.dto;

public class NaturschutzgebietSummaryDTO {
    private String name;
    private String ort;
    private int anzahlTiere;

    // Getter und Setter
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

    public int getAnzahlTiere() {
        return anzahlTiere;
    }

    public void setAnzahlTiere(int anzahlTiere) {
        this.anzahlTiere = anzahlTiere;
    }
}