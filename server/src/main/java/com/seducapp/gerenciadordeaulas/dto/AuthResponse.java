package com.seducapp.gerenciadordeaulas.dto;

public class AuthResponse {
    private String token;
    private String tipo;
    private String nome;

    public AuthResponse(String token, String tipo, String nome) {
        this.token = token;
        this.tipo = tipo;
        this.nome = nome;
    }

    // Getters e Setters
    public String getToken() {
        return token;
    }

    public String getTipo() {
        return tipo;
    }

    public String getNome() {
        return nome;
    }
}
