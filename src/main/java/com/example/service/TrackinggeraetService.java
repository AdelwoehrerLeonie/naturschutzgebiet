package com.example.service;

import com.example.entity.Trackinggeraet;
import com.example.repository.TrackinggeraetRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.util.List;

@ApplicationScoped
public class TrackinggeraetService {

    @Inject
    TrackinggeraetRepository repository;

    public List<Trackinggeraet> findAll() {
        return repository.listAll();
    }

    public void create(Trackinggeraet trackinggeraet) {
        repository.persist(trackinggeraet);
    }
}