package com.example.entity;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.*;

import javax.sound.midi.Track;
import java.time.LocalDate;

@Entity
public class Wanderung extends PanacheEntity {

    private String region;
    private String datum;
    public Long id;

    @ManyToOne
    @JoinColumn(name = "tier_id")
    private Tier tier;

    @ManyToOne
    @JoinColumn(name = "trackinggeraet_id", referencedColumnName = "id")
    private Trackinggeraet trackinggeraet;


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
