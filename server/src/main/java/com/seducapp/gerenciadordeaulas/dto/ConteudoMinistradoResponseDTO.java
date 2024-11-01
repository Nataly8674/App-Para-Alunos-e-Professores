package com.seducapp.gerenciadordeaulas.dto;

import java.time.LocalDate;
import java.time.LocalTime;

public class ConteudoMinistradoResponseDTO {
    private Long id;
    private String descricao;
    private LocalDate data;
    private String diaSemana;
    private LocalTime horaInicio;
    private LocalTime horaFim;
    
    // Construtores
    public ConteudoMinistradoResponseDTO() {}
    
    public ConteudoMinistradoResponseDTO(Long id, String descricao, LocalDate data,
                                       String diaSemana, LocalTime horaInicio, LocalTime horaFim) {
        this.id = id;
        this.descricao = descricao;
        this.data = data;
        this.diaSemana = diaSemana;
        this.horaInicio = horaInicio;
        this.horaFim = horaFim;
    }
    
    // Getters e Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public String getDiaSemana() {
        return diaSemana;
    }

    public void setDiaSemana(String diaSemana) {
        this.diaSemana = diaSemana;
    }

    public LocalTime getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(LocalTime horaInicio) {
        this.horaInicio = horaInicio;
    }

    public LocalTime getHoraFim() {
        return horaFim;
    }

    public void setHoraFim(LocalTime horaFim) {
        this.horaFim = horaFim;
    }
}