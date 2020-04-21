package com.bruno.futebol.service;

import com.bruno.futebol.model.Clube;
import com.bruno.futebol.repository.ClubeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class ClubeService {

    private ClubeRepository clubeRepository;

    @Autowired
    public ClubeService(ClubeRepository clubeRepository) {
        this.clubeRepository = clubeRepository;
    }

    public List<Clube> recuperarClubes() {
        List<Clube> clubes = new ArrayList<>();
        clubeRepository.findAll().forEach(clubes::add);

        return clubes;
    }

    public Clube recuperarClubePorId(UUID clubeId) {
        return clubeRepository.findById(clubeId).orElse(null);
    }
}
