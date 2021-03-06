package br.com.smartirrigation.smartirrigation.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

public class User implements Serializable {
    @JsonProperty("Id")
    private String  Id ;
    @JsonProperty("Email")
    private String  Email;
    @JsonProperty("Senha")
    private String  Senha;
    @JsonProperty("Nome")
    private String  Nome;

    public User(String id, String email, String senha, String nome) {
        Id = id;
        Email = email;
        Senha = senha;
        Nome = nome;
    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getSenha() {
        return Senha;
    }

    public void setSenha(String senha) {
        Senha = senha;
    }

    public String getNome() {
        return Nome;
    }

    public void setNome(String nome) {
        Nome = nome;
    }

}
