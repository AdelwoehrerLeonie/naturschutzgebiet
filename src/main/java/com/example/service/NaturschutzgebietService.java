package com.example.service;

import com.example.dto.CreateNaturschutzgebiet;
import com.example.dto.NaturschutzgebietDTO;
import com.example.dto.NaturschutzgebietSummaryDTO;
import com.example.entity.Naturschutzgebiet;
import com.example.entity.Tier;
import com.example.repository.NaturschutzgebietRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.NotFoundException;

import java.util.List;
import java.util.stream.Collectors;

import static io.quarkus.hibernate.orm.panache.PanacheEntityBase.persist;

@ApplicationScoped
public class NaturschutzgebietService {

    @Inject
    NaturschutzgebietRepository repository;

    public List<NaturschutzgebietSummaryDTO> findAllSummary() {
        return repository.listAll().stream()
                .map(naturschutzgebiet -> new NaturschutzgebietSummaryDTO(
                        naturschutzgebiet.name,
                        naturschutzgebiet.ort,
                        naturschutzgebiet.leiter != null ? naturschutzgebiet.leiter.getName() : null, // Hier wird der Name des Leiters zugewiesen
                        naturschutzgebiet.tiere.stream()
                                .map(Tier::getArt) // Liste von Tierarten
                                .collect(Collectors.toList())
                ))
                .collect(Collectors.toList());
    }

    public void createNaturschutzgebiet(CreateNaturschutzgebiet naturschutzgebiet) {
        Naturschutzgebiet myNaturschutzgebiet = CreateNaturschutzgebiet.createNaturschutzgebiet(naturschutzgebiet.name(), naturschutzgebiet.ort(), naturschutzgebiet.leiterId());
        Naturschutzgebiet.persist(myNaturschutzgebiet);
    }

    public List<NaturschutzgebietDTO> findByOrt(String ort) {
        return repository.find("ort", ort)
                .stream()
                .map(NaturschutzgebietDTO::createGetByOrt)
                .toList();
    }

    public List<NaturschutzgebietDTO> getAll() {
        List<Naturschutzgebiet> naturschutzgebiete = Naturschutzgebiet.listAll();
        return naturschutzgebiete.stream().map(NaturschutzgebietDTO::createGetAll).toList();
    }

    public void delete(Long id) {
    boolean deleted = repository.deleteById(id);
        if (!deleted) {
            throw new NotFoundException("Naturschutzgebiet mit ID " + id + " nicht gefunden");
        }
    }

    public NaturschutzgebietDTO update(NaturschutzgebietDTO naturschutzgebiet) {
        Naturschutzgebiet toUpdate = Naturschutzgebiet.findById(naturschutzgebiet.id());

        toUpdate.id = naturschutzgebiet.id();
        toUpdate.name = naturschutzgebiet.name();
        toUpdate.ort = naturschutzgebiet.ort();
        toUpdate.leiter.id = naturschutzgebiet.leiterId();

        persist(toUpdate);
        return naturschutzgebiet;
    }
}
