package com.example.dto;

import com.example.entity.Leiter;
import com.example.entity.Naturschutzgebiet;

import java.util.List;

public record CreateNaturschutzgebiet(String name, String ort, Long leiterId) {
    public static Naturschutzgebiet createNaturschutzgebiet(String name, String ort, Long leiterId) {
        Naturschutzgebiet naturschutzgebiet = new Naturschutzgebiet();
        naturschutzgebiet.name = name;
        naturschutzgebiet.ort = ort;
        naturschutzgebiet.leiter = Leiter.findById(leiterId);
        naturschutzgebiet.tiere = List.of();
        return naturschutzgebiet;
    }
}
