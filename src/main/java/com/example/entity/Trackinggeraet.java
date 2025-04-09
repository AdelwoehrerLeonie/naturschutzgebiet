package com.example.entity;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name="trackinggeraet")
public class Trackinggeraet extends PanacheEntity {

    public Long id;

    private String seriennummer;
    private String hersteller;

    @ManyToOne
    @JoinColumn(name = "tier_id")
    private Tier tier;

    @OneToMany(mappedBy = "trackinggeraet")
    private Set<Wanderung> wanderungen;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Tier getTier() {
        return tier;
    }

    public void setTier(Tier tier) {
        this.tier = tier;
    }

    public String getHersteller() {
        return hersteller;
    }

    public void setHersteller(String hersteller) {
        this.hersteller = hersteller;
    }

    public String getSeriennummer() {
        return seriennummer;
    }

    public void setSeriennummer(String seriennummer) {
        this.seriennummer = seriennummer;
    }
}