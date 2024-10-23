package com.seducapp.gerenciadordeaulas.dto;

public class LoginDTO {
    private String cpf;
    private String password;

    // Getters e setters
    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

