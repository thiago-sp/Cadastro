package com.estacio.teste.model;

public class Usuario {
    private String nomeCompleto;
    private String celular;
    private String email;
    private String senhaCadastrado;
   private String senhaCadastradoConfirmacao;


    public void setSenhaCadastradoConfirmacao(String senhaCadastradoConfirmacao) {
        this.senhaCadastradoConfirmacao = senhaCadastradoConfirmacao;
    }

    public String getNomeCompleto() {
        return nomeCompleto;
    }

    public void setNomeCompleto(String nomeCompleto) {
        this.nomeCompleto = nomeCompleto;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenhaCadastrado() {
        return senhaCadastrado;
    }

    public void setSenhaCadastrado(String senhaCadastrado) {
        this.senhaCadastrado = senhaCadastrado;
    }

    public String getSenhaCadastradoConfirmacao() {
        return senhaCadastradoConfirmacao;
    }

}
