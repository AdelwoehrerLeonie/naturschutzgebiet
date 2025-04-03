package com.example.entity;

import jakarta.persistence.*;

@Entity
public class Trackinggeraet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String seriennummer;
    private String hersteller;

    @ManyToOne
    @JoinColumn(name = "tier_id")
    private Tier tier;

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