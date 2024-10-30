package com.seducapp.gerenciadordeaulas.dto;

public class PresencaAlunoDTO {
    private Long idAluno;
    private Character presenca;

    // Getters e Setters
    public Long getIdAluno() { return idAluno; }
    public void setIdAluno(Long idAluno) { this.idAluno = idAluno; }
    public Character getPresenca() { return presenca; }
    public void setPresenca(Character presenca) { this.presenca = presenca; }
}