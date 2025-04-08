package com.example.entity;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class Tier extends PanacheEntity {

    private String name;
    private String art;

    @ManyToOne
    @JoinColumn(name = "naturschutzgebiet_id")
    private Naturschutzgebiet naturschutzgebiet;

    @OneToMany(mappedBy = "tier", cascade = CascadeType.ALL)
    private List<Wanderung> wanderungen;

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

    public String getArt() {
        return art;
    }

    public void setArt(String art) {
        this.art = art;
    }

    public Naturschutzgebiet getNaturschutzgebiet() {
        return naturschutzgebiet;
    }

    public void setNaturschutzgebiet(Naturschutzgebiet naturschutzgebiet) {
        this.naturschutzgebiet = naturschutzgebiet;
    }

    public List<Wanderung> getWanderungen() {
        return wanderungen;
    }

    public void setWanderungen(List<Wanderung> wanderungen) {
        this.wanderungen = wanderungen;
    }
}