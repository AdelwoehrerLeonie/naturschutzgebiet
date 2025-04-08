package com.example.entity;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class Wissenschaftler extends PanacheEntity {

    private String name;
    private String forschungsgebiet;

    /*
    @ManyToMany(mappedBy = "wissenschaftler")
    private List<Tier> tierarten;
     */
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    /*

    public List<Tier> getTierarten() {
        return tierarten;
    }

    public void setTierarten(List<Tier> tierarten) {
        this.tierarten = tierarten;
    }

     */

    public String getForschungsgebiet() {
        return forschungsgebiet;
    }

    public void setForschungsgebiet(String forschungsgebiet) {
        this.forschungsgebiet = forschungsgebiet;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}