package br.com.smartirrigation.smartirrigation.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

public class EquipResponse implements Serializable {

    @JsonProperty("IdEquipamento")
    private String IdEquipamento;
    @JsonProperty("Nome")
    private String Nome;

    public EquipResponse(){

    }
    public EquipResponse(String idEquipamento, String nome) {
        IdEquipamento = idEquipamento;
        Nome = nome;
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
