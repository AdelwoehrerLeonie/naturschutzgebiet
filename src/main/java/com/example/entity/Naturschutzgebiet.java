package com.example.entity;

import com.example.dto.NaturschutzgebietSummaryDTO;
import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class Naturschutzgebiet extends PanacheEntity {

    private String name;
    private String ort;

    @ManyToOne
    @JoinColumn(name = "leiter_id")  // Verknüpft mit der ID der Leiter-Entität
    private Leiter leiter;

    @OneToMany(mappedBy = "naturschutzgebiet", cascade = CascadeType.ALL)
    private List<Tier> tiere;

    public Leiter getLeiter() {
        return leiter;
    }

    public void setLeiter(Leiter leiter) {
        this.leiter = leiter;
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
