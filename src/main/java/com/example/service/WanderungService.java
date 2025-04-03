package com.example.service;

import com.example.dto.WanderungDTO;
import com.example.entity.Naturschutzgebiet;
import com.example.entity.Wanderung;
import com.example.repository.WanderungRepository;
import com.example.websocket.LiveUpdateSocket;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@ApplicationScoped
public class WanderungService {

    @Inject
    WanderungRepository repository;

    @Inject
    LiveUpdateSocket websocket;

    @Transactional
    public void create(Wanderung wanderung) {
        repository.persist(wanderung);
        // Broadcast der DTO-Daten
        WanderungDTO dto = new WanderungDTO();
        dto.setId(wanderung.getId());
        dto.setDatum(wanderung.getDatum());
        dto.setRegion(wanderung.getRegion());
        dto.setTierName(wanderung.getTier().getName());
        websocket.broadcast(dto);
    }

    public List<WanderungDTO> findAllDTOs() {
        return repository.listAll().stream().map(w -> {
            WanderungDTO dto = new WanderungDTO();
            dto.setId(w.getId());
            dto.setDatum(w.getDatum());
            dto.setRegion(w.getRegion());
            dto.setTierName(w.getTier().getName());
            return dto;
        }).collect(Collectors.toList());
    }

    public List<Wanderung> findAll() {
        return repository.listAll();
    }
}