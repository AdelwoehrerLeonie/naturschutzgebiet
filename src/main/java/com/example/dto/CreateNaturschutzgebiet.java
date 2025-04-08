package com.example.dto;

import com.example.entity.Leiter;
import com.example.entity.Naturschutzgebiet;

public record CreateNaturschutzgebiet(String name, String ort, Long leiterId) {
    public static Naturschutzgebiet createNaturschutzgebiet(String name, String ort, Long leiterId) {
        Naturschutzgebiet naturschutzgebiet = new Naturschutzgebiet();
        naturschutzgebiet.setName(name);
        naturschutzgebiet.setOrt(ort);
        naturschutzgebiet.setLeiter(Leiter.findById(leiterId));
        return naturschutzgebiet;
    }
}
