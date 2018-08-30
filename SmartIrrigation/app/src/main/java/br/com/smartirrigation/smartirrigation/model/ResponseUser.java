package br.com.smartirrigation.smartirrigation.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

public class ResponseUser implements Serializable {

   @JsonProperty("Status")
   private String status;
    @JsonProperty("Mensagem")
    private String mensagem;

    public ResponseUser() {

    }

    public ResponseUser(String status, String mensagem) {
        this.status = status;
        this.mensagem = mensagem;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }
}
