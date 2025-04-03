package com.example.controller;

import com.example.entity.Giftpflanze;
import com.example.service.GiftpflanzeService;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

import java.util.List;

@Path("/giftpflanze")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class GiftpflanzeController {
    @Inject
    GiftpflanzeService service;

    @GET
    public List<Giftpflanze> getAll() {
        return service.findAll();
    }

    @POST
    public void create(Giftpflanze giftpflanze) {
        service.create(giftpflanze);
    }
}