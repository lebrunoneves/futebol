package com.bruno.futebol.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.util.UUID;

@Entity
public class Clube {

    @Id
    private UUID clubeId;

    @Column(length = 5)
    @Size(min = 2, max = 5)
    private String sigla;

    private String nomeCurto;

    @Column(unique = true)
    private String nomeLongo;

    private LocalDate fundacao;

    @JsonIgnore
    @OneToOne
    private Escudo escudo;

    public UUID getClubeId() {
        return clubeId;
    }

    public void setClubeId(UUID clubeId) {
        this.clubeId = clubeId;
    }

    public String getSigla() {
        return sigla;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
    }

    public String getNomeCurto() {
        return nomeCurto;
    }

    public void setNomeCurto(String nomeCurto) {
        this.nomeCurto = nomeCurto;
    }

    public String getNomeLongo() {
        return nomeLongo;
    }

    public void setNomeLongo(String nomeLongo) {
        this.nomeLongo = nomeLongo;
    }

    public LocalDate getFundacao() {
        return fundacao;
    }

    public void setFundacao(LocalDate fundacao) {
        this.fundacao = fundacao;
    }

    public Escudo getEscudo() {
        return escudo;
    }

    public void setEscudo(Escudo escudo) {
        this.escudo = escudo;
    }
}
