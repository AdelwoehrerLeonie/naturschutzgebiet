package com.example.controller;

import com.example.entity.Wanderung;
import com.example.service.WanderungService;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

import java.util.List;

@Path("/wanderung")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class WanderungController {
    @Inject
    WanderungService service;

    @GET
    public List<Wanderung> getAll() {
        return service.findAll();
    }

    @POST
    public void create(Wanderung wanderung) {
        service.create(wanderung);
    }
}