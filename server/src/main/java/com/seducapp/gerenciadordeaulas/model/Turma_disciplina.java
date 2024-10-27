package com.seducapp.gerenciadordeaulas.model;

import java.io.Serializable;

import com.seducapp.gerenciadordeaulas.model.pk.Turma_disciplinaPk;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Turma_disciplina implements Serializable {
    private static final long serialVersionUID = 1L;

    @EmbeddedId
    private Turma_disciplinaPk id = new Turma_disciplinaPk();

    @ManyToOne
    @JoinColumn(name = "id_Professor")
    private Professor professor;

    public Turma_disciplina() {
        // Construtor padrão (necessário para o Hibernate)
    }

    public Turma_disciplina(Turma turma, Disciplina disciplina) {
        id.setTurma(turma);
        id.setDisciplina(disciplina);
    }

    public Turma getTurma() {
        return id.getTurma();
    }

    public void setTurma(Turma turma) {
        id.setTurma(turma);
    }

    public Disciplina getDisciplina() {
        return id.getDisciplina(); // Corrigido para retornar Disciplina
    }

    public void setDisciplina(Disciplina disciplina) {
        id.setDisciplina(disciplina); // Corrigido para definir Disciplina
    }
}
