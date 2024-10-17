package com.seducapp.gerenciadordeaulas.model.pk;

import java.io.Serializable;
import java.util.Objects;

import com.seducapp.gerenciadordeaulas.model.Disciplina;
import com.seducapp.gerenciadordeaulas.model.Turma;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Embeddable
public class Turma_disciplinaPk implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@ManyToOne
	@JoinColumn(name = "id_turma")
	private Turma turma;
	
	@ManyToOne
	@JoinColumn(name = "id_disciplina")
	private Disciplina disciplina;
	
	public Turma getTurma() {
		return turma;
	}
	public void setTurma(Turma turma) {
		this.turma = turma;
	}
	public Disciplina getDisciplina() {
		return disciplina;
	}
	public void setDisciplina(Disciplina disciplina) {
		this.disciplina = disciplina;
	}
	@Override
	public int hashCode() {
		return Objects.hash(disciplina, turma);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Turma_disciplinaPk other = (Turma_disciplinaPk) obj;
		return Objects.equals(disciplina, other.disciplina) && Objects.equals(turma, other.turma);
	}
	
	

}
