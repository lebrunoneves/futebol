package com.bruno.futebol.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.UUID;

@Entity
public class Escudo {

    @Id
    private UUID escudoId;
    private byte[] imagem;

    public UUID getEscudoId() {
        return escudoId;
    }

    public void setEscudoId(UUID escudoId) {
        this.escudoId = escudoId;
    }

    public byte[] getImagem() {
        return imagem;
    }

    public void setImagem(byte[] imagem) {
        this.imagem = imagem;
    }
}
