package com.seducapp.gerenciadordeaulas.dto;

import java.time.LocalDate;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.NotBlank;

public class ConteudoMinistradoRequestDTO {
    @NotBlank(message = "A descrição é obrigatória")
    private String descricao;
    
    @NotNull(message = "A data é obrigatória")
    private LocalDate data;
    
    @NotNull(message = "O ID do horário é obrigatório")
    private Long horarioId;
    
    // Getters e Setters
    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public Long getHorarioId() {
        return horarioId;
    }

    public void setHorarioId(Long horarioId) {
        this.horarioId = horarioId;
    }
}
