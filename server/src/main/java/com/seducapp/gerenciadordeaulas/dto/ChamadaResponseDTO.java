package com.seducapp.gerenciadordeaulas.dto;

import java.time.LocalDate;
import java.util.List;

public class ChamadaResponseDTO {
    private Long idChamada;
    private LocalDate data;
    private String turma;
    private String disciplina;
    private List<AlunoPresencaDTO> presencas;

    // Getters e Setters
    public Long getIdChamada() { return idChamada; }
    public void setIdChamada(Long idChamada) { this.idChamada = idChamada; }
    public LocalDate getData() { return data; }
    public void setData(LocalDate data) { this.data = data; }
    public String getTurma() { return turma; }
    public void setTurma(String turma) { this.turma = turma; }
    public String getDisciplina() { return disciplina; }
    public void setDisciplina(String disciplina) { this.disciplina = disciplina; }
    public List<AlunoPresencaDTO> getPresencas() { return presencas; }
    public void setPresencas(List<AlunoPresencaDTO> presencas) { this.presencas = presencas; }
}