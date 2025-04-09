package com.example.dto;

import com.example.entity.Naturschutzgebiet;
import com.example.entity.Tier;
import io.quarkus.hibernate.orm.panache.PanacheEntityBase;

public record TierDTO(Long id, Long naturschutzgebiet_id, String art, String name) {
    public static TierDTO createGetTierList(Tier tier) {
        return new TierDTO(tier.getId(), tier.getNaturschutzgebiet().id, tier.getArt(), tier.getName());
    }
    public static TierDTO createGetTierById(Tier tier) {
        return new TierDTO(tier.getId(), tier.getNaturschutzgebiet().id, tier.getArt(), tier.getName());
    }
}