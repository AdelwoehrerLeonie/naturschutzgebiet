package com.example.repository;

import com.example.entity.Wissenschaftler;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class WissenschaftlerRepository implements PanacheRepository<Wissenschaftler> {
}