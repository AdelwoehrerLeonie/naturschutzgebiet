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

import java.util.Collections;
import java.util.List;

@Path("/naturschutzgebiet")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class NaturschutzgebietController {
    @Inject
    NaturschutzgebietService service;

    @GET
    @Path("/{list}")
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

    @PUT
    @Path("/{id}")
    public Response update(@PathParam("id") Long id, NaturschutzgebietDTO dto) {
        NaturschutzgebietDTO updated = service.update(dto);
        return Response.ok(updated).build();
    }

    @DELETE
    @Path("/{id}")
    public Response delete(@PathParam("id") Long id) {
        service.delete(id);
        return Response.noContent().build(); // 204 No Content
    }


    @GET
    public Response getByOrt(@QueryParam("ort") String ort) {
        if (ort != null && !ort.isBlank()) {
            List<NaturschutzgebietDTO> result = service.findByOrt(ort);
            return Response.ok(result).build();
        } else {
            List<NaturschutzgebietDTO> result = service.getAll();
            return Response.ok(result).build();
        }
    }





}