package com.example.controller;
import com.example.entity.Tier;
import com.example.service.TierService;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

import java.util.List;
@Path("/tier")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class TierController {
    @Inject
    TierService service;

    @GET
    public List<Tier> getAll() {
        return service.findAll();
    }

    @POST
    public void create(Tier tier) {
        service.create(tier);
    }
}