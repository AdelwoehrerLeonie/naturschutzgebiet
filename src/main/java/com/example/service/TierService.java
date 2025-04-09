package com.example.service;

import com.example.dto.NaturschutzgebietDTO;
import com.example.dto.TierDTO;
import com.example.entity.Naturschutzgebiet;
import com.example.entity.Tier;
import com.example.repository.TierRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.NotFoundException;

import java.util.List;

import static io.quarkus.hibernate.orm.panache.PanacheEntityBase.persist;

@ApplicationScoped
public class TierService {

    @Inject
    TierRepository repository;

    public void create(Tier tier) {
        repository.persist(tier);
    }

    public void delete(Long id) {
        boolean deleted = repository.deleteById(id);
        if (!deleted) {
            throw new NotFoundException("Tier mit ID " + id + " nicht gefunden");
        }
    }

    public TierDTO update(TierDTO tier) {
        Tier toUpdate = Tier.findById(tier.id());

        toUpdate.setId(tier.id());
        toUpdate.setArt(tier.art());
        toUpdate.setName(tier.name());

        Naturschutzgebiet gebiet = Naturschutzgebiet.findById(tier.naturschutzgebiet_id());
        toUpdate.setNaturschutzgebiet(gebiet);

        persist(toUpdate);
        return tier;
    }
}
