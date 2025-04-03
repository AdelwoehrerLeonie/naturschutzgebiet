package com.example.entity;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class Wanderung {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String region;
    private String datum;

    @ManyToOne
    @JoinColumn(name = "tier_id")
    private Tier tier;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public LocalDate getDatum() {
        return LocalDate.parse(datum);
    }

    public void setDatum(String datum) {
        this.datum = datum;
    }

    public Tier getTier() {
        return tier;
    }

    public void setTier(Tier tier) {
        this.tier = tier;
    }
}
