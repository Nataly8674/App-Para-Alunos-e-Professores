package com.seducapp.gerenciadordeaulas.dto;

import jakarta.validation.constraints.NotBlank;

public class LoginDTO {
    
    @NotBlank(message = "O CPF é obrigatório.")
    private String cpf;
    
    @NotBlank(message = "A senha é obrigatória.")
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

