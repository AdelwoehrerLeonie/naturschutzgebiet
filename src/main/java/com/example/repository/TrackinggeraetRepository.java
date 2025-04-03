package com.example.repository;

import com.example.entity.Trackinggeraet;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class TrackinggeraetRepository implements PanacheRepository<Trackinggeraet> {
}