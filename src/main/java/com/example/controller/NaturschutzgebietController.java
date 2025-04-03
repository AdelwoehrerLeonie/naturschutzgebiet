package com.example.controller;

import com.example.entity.Naturschutzgebiet;
import com.example.service.NaturschutzgebietService;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

import java.util.List;

@Path("/naturschutzgebiet")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class NaturschutzgebietController {
    @Inject
    NaturschutzgebietService service;

    @GET
    public List<Naturschutzgebiet> getAll() {
        return service.findAll();
    }

    @POST
    public void create(Naturschutzgebiet naturschutzgebiet) {
        service.create(naturschutzgebiet);
    }
}