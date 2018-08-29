package br.com.smartirrigation.smartirrigation.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

public class ResponseUser implements Serializable {
    @JsonProperty("boolean")
    private boolean teste;

    public ResponseUser(boolean teste) {
        this.teste = teste;
    }

    public boolean isTeste() {
        return teste;
    }

    public void setTeste(boolean teste) {
        this.teste = teste;
    }


}
