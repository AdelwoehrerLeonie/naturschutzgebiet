package com.example.dto;

import com.example.entity.Leiter;
import com.example.entity.Naturschutzgebiet;

import java.util.List;

public record NaturschutzgebietDTO(Long id, String name, String ort, Long leiterId) {
    public static NaturschutzgebietDTO createGetById (Naturschutzgebiet naturschutzgebiet) {
        return new NaturschutzgebietDTO(naturschutzgebiet.id, naturschutzgebiet.name, naturschutzgebiet.ort,naturschutzgebiet.leiter.getId());
    }
    public static NaturschutzgebietDTO createGetByOrt (Naturschutzgebiet naturschutzgebiet) {
        return new NaturschutzgebietDTO(naturschutzgebiet.id, naturschutzgebiet.name, naturschutzgebiet.ort,naturschutzgebiet.leiter.getId());
    }
    public static NaturschutzgebietDTO createGetAll(Naturschutzgebiet naturschutzgebiet) {
        return new NaturschutzgebietDTO(naturschutzgebiet.id, naturschutzgebiet.name, naturschutzgebiet.ort,naturschutzgebiet.leiter.getId());
    }
}
