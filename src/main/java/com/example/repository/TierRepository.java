package com.example.repository;

import com.example.entity.Tier;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class TierRepository implements PanacheRepository<Tier> {
}