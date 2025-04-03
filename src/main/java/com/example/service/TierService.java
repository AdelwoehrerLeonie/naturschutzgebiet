package com.example.service;

import com.example.entity.Tier;
import com.example.repository.TierRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.util.List;

@ApplicationScoped
public class TierService {

    @Inject
    TierRepository repository;

    public List<Tier> findAll() {
        return repository.listAll();
    }

    public void create(Tier tier) {
        repository.persist(tier);
    }
}
