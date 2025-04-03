package com.example.controller;

import com.example.entity.Trackinggeraet;
import com.example.service.TrackinggeraetService;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

import java.util.List;

@Path("/trackinggeraet")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class TrackinggeraetController {
    @Inject
    TrackinggeraetService service;

    @GET
    public List<Trackinggeraet> getAll() {
        return service.findAll();
    }

    @POST
    public void create(Trackinggeraet trackinggeraet) {
        service.create(trackinggeraet);
    }
}