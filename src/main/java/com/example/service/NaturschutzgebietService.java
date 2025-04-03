package com.example.service;

import com.example.dto.NaturschutzgebietSummaryDTO;
import com.example.entity.Naturschutzgebiet;
import com.example.repository.NaturschutzgebietRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.util.List;
import java.util.stream.Collectors;

@ApplicationScoped
public class NaturschutzgebietService {

    @Inject
    NaturschutzgebietRepository repository;

    public List<NaturschutzgebietSummaryDTO> findAllSummary() {
        return repository.listAll().stream()
                .map(naturschutzgebiet -> new NaturschutzgebietSummaryDTO(
                        naturschutzgebiet.getName(),
                        naturschutzgebiet.getOrt(),
                        naturschutzgebiet.getTiere().size() // Angenommen, es gibt eine Methode getTiere(), die eine Liste von Tieren zurückgibt
                ))
                .collect(Collectors.toList());
    }


    public void create(Naturschutzgebiet naturschutzgebiet) {
        repository.persist(naturschutzgebiet);
    }
}