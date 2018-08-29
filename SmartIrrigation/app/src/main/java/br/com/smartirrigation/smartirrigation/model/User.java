package br.com.smartirrigation.smartirrigation.model;

import java.io.Serializable;

public class User implements Serializable {

    private String  Id ;
    private String  Email;
    private String  Senha;
    private String  Nome;

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
