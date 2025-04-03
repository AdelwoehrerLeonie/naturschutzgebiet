package com.example.service;

import com.example.entity.Naturschutzgebiet;
import com.example.repository.NaturschutzgebietRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.util.List;

@ApplicationScoped
public class NaturschutzgebietService {

    @Inject
    NaturschutzgebietRepository repository;

    public List<Naturschutzgebiet> findAll() {
        return repository.listAll();
    }

    public void create(Naturschutzgebiet naturschutzgebiet) {
        repository.persist(naturschutzgebiet);
    }
}