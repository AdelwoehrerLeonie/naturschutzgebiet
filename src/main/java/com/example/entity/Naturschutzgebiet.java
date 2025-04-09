package com.example.entity;

import com.example.dto.NaturschutzgebietSummaryDTO;
import io.quarkus.hibernate.orm.panache.PanacheEntity;
import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class Naturschutzgebiet extends PanacheEntity {

    public Long id;

    public String name;
    public String ort;

    @ManyToOne
    @JoinColumn(name = "leiter_id")  // Verknüpft mit der ID der Leiter-Entität
    public Leiter leiter;

    @OneToMany(mappedBy = "naturschutzgebiet", cascade = CascadeType.ALL)
    public List<Tier> tiere;
}
