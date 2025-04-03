package com.example.service;

import com.example.entity.Wissenschaftler;
import com.example.repository.WissenschaftlerRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.util.List;

@ApplicationScoped
public class WissenschaftlerService {

    @Inject
    WissenschaftlerRepository repository;

    public List<Wissenschaftler> findAll() {
        return repository.listAll();
    }

    public void create(Wissenschaftler wissenschaftler) {
        repository.persist(wissenschaftler);
    }
}