package com.example.dto;

import java.util.List;

public class NaturschutzgebietSummaryDTO {
    private String name;
    private String ort;
    private String leiter;  // Leiter ist nun als Name in DTO
    private List<String> tierarten;

    public NaturschutzgebietSummaryDTO() {}

    public NaturschutzgebietSummaryDTO(String name, String ort, String leiter, List<String> tierarten) {
        this.name = name;
        this.ort = ort;
        this.leiter = leiter;
        this.tierarten = tierarten;
    }

    public String getName() { return name; }
    public String getOrt() { return ort; }
    public String getLeiter() { return leiter; }
    public List<String> getTierarten() { return tierarten; }

    public void setName(String name) { this.name = name; }
    public void setOrt(String ort) { this.ort = ort; }
    public void setLeiter(String leiter) { this.leiter = leiter; }
    public void setTierarten(List<String> tierarten) { this.tierarten = tierarten; }
}
