package com.seducapp.gerenciadordeaulas.model;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "disciplina")
public class Disciplina {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_disciplina;
    private String nome_disciplina;
    
    @OneToMany(mappedBy = "disciplina")
	private Set<Turma_disciplina> turma_disciplinas = new HashSet<>();
	
	public Disciplina() {
		
	}

	public Disciplina(Long id_disciplina, String nome_disciplina) {
		this.id_disciplina = id_disciplina;
		this.nome_disciplina = nome_disciplina;
	}

	public Long getId_disciplina() {
		return id_disciplina;
	}

	public void setId_disciplina(Long id_disciplina) {
		this.id_disciplina = id_disciplina;
	}

	public String getNome_disciplina() {
		return nome_disciplina;
	}

	public void setNome_disciplina(String nome_disciplina) {
		this.nome_disciplina = nome_disciplina;
	}

	public Set<Turma_disciplina> getDisciplinas() {
		return turma_disciplinas;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id_disciplina);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Disciplina other = (Disciplina) obj;
		return Objects.equals(id_disciplina, other.id_disciplina);
	}
}
