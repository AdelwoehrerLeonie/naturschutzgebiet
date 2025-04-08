package com.example.service;

import com.example.dto.GiftpflanzeDTO;
import com.example.entity.Giftpflanzen;
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
    public void create(Giftpflanzen giftpflanzen) {
        repository.persist(giftpflanzen);
        // Broadcast der DTO-Daten
        GiftpflanzeDTO dto = new GiftpflanzeDTO();
        dto.setId(giftpflanzen.getId());
        dto.setName(giftpflanzen.getName());
        dto.setToxizitaetsstufe(giftpflanzen.getToxizitaetsstufe());
        dto.setBeschreibung(giftpflanzen.getBeschreibung());
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


    public List<Giftpflanzen> findAll() {
        return repository.listAll();
    }

    /* OHNE DTOs
    public void create(Giftpflanze giftpflanze) {
        repository.persist(giftpflanze);
    }

     */
}