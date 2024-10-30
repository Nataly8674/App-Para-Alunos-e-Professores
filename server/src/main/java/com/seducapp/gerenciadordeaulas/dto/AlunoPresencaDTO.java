package com.seducapp.gerenciadordeaulas.dto;

public class AlunoPresencaDTO {
    private Long idAluno;
    private String nomeAluno;
    private Character presenca;

    // Getters e Setters
    public Long getIdAluno() { return idAluno; }
    public void setIdAluno(Long idAluno) { this.idAluno = idAluno; }
    public String getNomeAluno() { return nomeAluno; }
    public void setNomeAluno(String nomeAluno) { this.nomeAluno = nomeAluno; }
    public Character getPresenca() { return presenca; }
    public void setPresenca(Character presenca) { this.presenca = presenca; }
}
