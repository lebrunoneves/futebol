package com.bruno.futebol.controller;

import com.bruno.futebol.model.Clube;
import com.bruno.futebol.service.ClubeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("api/v1/clubes")
public class ClubeController {

    private ClubeService clubeService;

    @Autowired
    public ClubeController(ClubeService clubeService) {
        this.clubeService = clubeService;
    }

    @GetMapping
    public ResponseEntity getClubes() {
        return ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body(clubeService.recuperarClubes());
    }

    @GetMapping("/{clubeId}")
    public ResponseEntity getClubePorId(@PathVariable UUID clubeId) {
        Clube clube = clubeService.recuperarClubePorId(clubeId);
        if(clube == null)
            return ResponseEntity.notFound().build();

        return ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body(clube);
    }

    @GetMapping("/{clubeId}/escudo")
    public ResponseEntity getEscudo(@PathVariable UUID clubeId) {
        Clube clube = clubeService.recuperarClubePorId(clubeId);

        if(clube == null || clube.getEscudo() == null)
            return ResponseEntity.notFound().build();

        return ResponseEntity.ok().contentType(MediaType.IMAGE_PNG).body(clube.getEscudo().getImagem());
    }

}
