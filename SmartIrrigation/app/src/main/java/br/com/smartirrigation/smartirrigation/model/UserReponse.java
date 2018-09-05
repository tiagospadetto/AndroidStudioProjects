package br.com.smartirrigation.smartirrigation.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

public class UserReponse  implements Serializable {

    @JsonProperty("Id")
    private String  id ;
    @JsonProperty("Email")
    private String  email;
    @JsonProperty("Senha")
    private String  senha;
    @JsonProperty("Nome")
    private String  nome;

    public UserReponse() {
    }

    public UserReponse(String id, String email, String senha, String nome) {
        this.id = id;
        this.email = email;
        this.senha = senha;
        this.nome = nome;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
