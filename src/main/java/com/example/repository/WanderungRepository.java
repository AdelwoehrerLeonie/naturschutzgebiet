package com.example.repository;

import com.example.entity.Wanderung;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class WanderungRepository implements PanacheRepository<Wanderung> {
}
