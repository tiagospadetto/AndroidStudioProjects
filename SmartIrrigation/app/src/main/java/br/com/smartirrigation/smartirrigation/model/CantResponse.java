package br.com.smartirrigation.smartirrigation.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

public class CantResponse implements Serializable {
    @JsonProperty("IdCanteiro")
    String IdCanteiro ;
    @JsonProperty("IdEquipamento")
    String IdEquipamento ;
    @JsonProperty("Nome")
    String Nome;

    public CantResponse() {
    }

    public String getIdCanteiro() {
        return IdCanteiro;
    }

    public void setIdCanteiro(String idCanteiro) {
        IdCanteiro = idCanteiro;
    }

    public String getIdEquipamento() {
        return IdEquipamento;
    }

    public void setIdEquipamento(String idEquipamento) {
        IdEquipamento = idEquipamento;
    }

    public String getNome() {
        return Nome;
    }

    public void setNome(String nome) {
        Nome = nome;
    }
}
