package com.seducapp.gerenciadordeaulas.model;

import java.io.Serializable;
import java.util.Objects;

public class TurmaDisciplinaId implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Long id_turma;
    private Long id_disciplina;

    public TurmaDisciplinaId() {
    }

    public TurmaDisciplinaId(Long id_turma, Long id_disciplina) {
        this.id_turma = id_turma;
        this.id_disciplina = id_disciplina;
    }

    // Getters e Setters
    public Long getId_turma() {
        return id_turma;
    }

    public void setId_turma(Long id_turma) {
        this.id_turma = id_turma;
    }

    public Long getId_disciplina() {
        return id_disciplina;
    }

    public void setId_disciplina(Long id_disciplina) {
        this.id_disciplina = id_disciplina;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TurmaDisciplinaId that = (TurmaDisciplinaId) o;
        return Objects.equals(id_turma, that.id_turma) &&
                Objects.equals(id_disciplina, that.id_disciplina);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id_turma, id_disciplina);
    }
}
