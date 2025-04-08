package com.example.controller;

import com.example.dto.CreateNaturschutzgebiet;
import com.example.dto.NaturschutzgebietDTO;
import com.example.dto.NaturschutzgebietSummaryDTO;
import com.example.entity.Naturschutzgebiet;
import com.example.service.NaturschutzgebietService;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;

@Path("/naturschutzgebiet")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class NaturschutzgebietController {
    @Inject
    NaturschutzgebietService service;

    @GET
    public List<NaturschutzgebietSummaryDTO> getAll() {
        return service.findAllSummary();
    }

    @GET
    @Path("/{id}")
    public NaturschutzgebietDTO getById(@PathParam("id") Long id) {
        return NaturschutzgebietDTO.createGetById(Naturschutzgebiet.findById(id));
    }


    @POST
    @Transactional
    public void create(CreateNaturschutzgebiet naturschutzgebiet) {
        service.createNaturschutzgebiet(naturschutzgebiet);
    }

    /*
    @PUT
    @Path("/{id}")
    public NaturschutzgebietSummaryDTO update(@PathParam("id") Long id, NaturschutzgebietSummaryDTO dto) {
        return service.update(id, dto);
    }


    @DELETE
    @Path("/{id}")
    public void delete(@PathParam("id") Long id) {
        service.delete(id);
    }


    @GET
    @Path("/")
    public List<NaturschutzgebietSummaryDTO> getByOrt(@QueryParam("ort") String ort) {
        if (ort != null && !ort.isBlank()) {
            return service.findByOrt(ort);
        } else {
            return service.findAll();
        }
    }

     */



}