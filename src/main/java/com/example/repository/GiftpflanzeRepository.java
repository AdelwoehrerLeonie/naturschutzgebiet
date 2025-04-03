package com.example.repository;

import com.example.entity.Giftpflanze;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class GiftpflanzeRepository implements PanacheRepository<Giftpflanze> {
}