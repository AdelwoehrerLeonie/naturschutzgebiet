package com.example.service;

import com.example.dto.GiftpflanzeDTO;
import com.example.entity.Giftpflanze;
import com.example.repository.GiftpflanzeRepository;
import com.example.websocket.LiveUpdateSocket;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@ApplicationScoped
public class GiftpflanzeService {

    @Inject
    GiftpflanzeRepository repository;

    @Inject
    LiveUpdateSocket websocket;

    @Transactional
    public void create(Giftpflanze giftpflanze) {
        repository.persist(giftpflanze);
        // Broadcast der DTO-Daten
        GiftpflanzeDTO dto = new GiftpflanzeDTO();
        dto.setId(giftpflanze.getId());
        dto.setName(giftpflanze.getName());
        dto.setToxizitaetsstufe(giftpflanze.getToxizitaetsstufe());
        dto.setBeschreibung(giftpflanze.getBeschreibung());
        websocket.broadcast(dto);
    }

    public List<GiftpflanzeDTO> findAllDTOs() {
        return repository.listAll().stream().map(g -> {
            GiftpflanzeDTO dto = new GiftpflanzeDTO();
            dto.setId(g.getId());
            dto.setName(g.getName());
            dto.setToxizitaetsstufe(g.getToxizitaetsstufe());
            dto.setBeschreibung(g.getBeschreibung());
            return dto;
        }).collect(Collectors.toList());
    }


    public List<Giftpflanze> findAll() {
        return repository.listAll();
    }

    /* OHNE DTOs
    public void create(Giftpflanze giftpflanze) {
        repository.persist(giftpflanze);
    }

     */
}