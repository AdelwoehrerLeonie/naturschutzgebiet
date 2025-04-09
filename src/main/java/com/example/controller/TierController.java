package com.example.controller;
import com.example.dto.CreateNaturschutzgebiet;
import com.example.dto.NaturschutzgebietDTO;
import com.example.dto.TierDTO;
import com.example.entity.Naturschutzgebiet;
import com.example.entity.Tier;
import com.example.service.TierService;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;
import java.util.stream.Collectors;

@Path("/tiere")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class TierController {
    @Inject
    TierService service;

    @GET
    @Path("/list")
    public List<TierDTO> getAll() {
        return Tier.<Tier>listAll().stream()
                .map(TierDTO::createGetTierList)
                .collect(Collectors.toList());
    }

    @GET
    @Path("/{id}")
    public TierDTO getById(@PathParam("id") Long id) {
        return TierDTO.createGetTierById(Tier.findById(id));
    }

    @POST
    @Transactional
    public void create(Tier tier) {
        service.create(tier);
    }

    @PUT
    @Path("/{id}")
    public Response update(@PathParam("id") Long id, TierDTO dto) {
        TierDTO updated = service.update(dto);
        return Response.ok(updated).build();
    }

    @DELETE
    @Path("/{id}")
    public Response delete(@PathParam("id") Long id) {
        service.delete(id);
        return Response.noContent().build(); // 204 No Content
    }

    @GET
    public Response getTiereByGebietId(@QueryParam("gebietId") Long gebietId) {
        if (gebietId != null) {
            List<Tier> tiere = Tier.find("naturschutzgebiet.id", gebietId).list();
            List<TierDTO> dtoList = tiere.stream()
                    .map(TierDTO::createGetTierList)
                    .collect(Collectors.toList());
            return Response.ok(dtoList).build();
        } else {
            // Optional: Alle Tiere zurückgeben, wenn kein Gebiet angegeben wurde
            List<Tier> allTiere = Tier.listAll();
            List<TierDTO> dtoList = allTiere.stream()
                    .map(TierDTO::createGetTierList)
                    .collect(Collectors.toList());
            return Response.ok(dtoList).build();
        }
    }
    @GET
    @Path("/naturschutzgebiet/{gebietId}")
    public Response getTiereByNaturschutzgebietId(@PathParam("gebietId") Long gebietId) {
        List<Tier> tiere = Tier.find("naturschutzgebiet.id", gebietId).list();
        List<TierDTO> dtoList = tiere.stream()
                .map(TierDTO::createGetTierList)
                .collect(Collectors.toList());
        return Response.ok(dtoList).build();
    }


}