package com.example.controller;

import com.example.entity.Wissenschaftler;
import com.example.service.WissenschaftlerService;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

import java.util.List;

@Path("/wissenschaftler")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class WissenschaftlerController {
    @Inject
    WissenschaftlerService service;

    @GET
    public List<Wissenschaftler> getAll() {
        return service.findAll();
    }

    @POST
    public void create(Wissenschaftler wissenschaftler) {
        service.create(wissenschaftler);
    }
}