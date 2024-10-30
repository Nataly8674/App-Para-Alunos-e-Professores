package com.seducapp.gerenciadordeaulas.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "turma")
public class Turma implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_turma;
	private String nome_turma;
	
	@OneToMany(mappedBy = "turma")
	@JsonIgnore
	private List<Aluno> alunos = new ArrayList<>();
	
	@ManyToOne
	@JoinColumn(name = "id_modalidade")
	private Modalidades modalidade;
	
	@ManyToOne
	@JoinColumn(name = "id_serie")
	private Serie serie;
	
	@OneToMany(mappedBy = "turma")
	@JsonIgnore
	private Set<Turma_disciplina> turma_disciplinas = new HashSet<>();
	
	public Turma() {
		
	}

	public Turma(Long id_turma, String nome_turma, Modalidades modalidade, Serie serie) {
		this.id_turma = id_turma;
		this.nome_turma = nome_turma;
		this.modalidade = modalidade;
		this.serie = serie;
	}

	public Long getId_turma() {
		return id_turma;
	}

	public void setId_turma(Long id_turma) {
		this.id_turma = id_turma;
	}

	public String getNome_turma() {
		return nome_turma;
	}

	public void setNome_turma(String nome_turma) {
		this.nome_turma = nome_turma;
	}

	public List<Aluno> getAlunos() {
		return alunos;
	}
	
	public Modalidades getModalidade() {
		return modalidade;
	}

	public void setModalidade(Modalidades modalidade) {
		this.modalidade = modalidade;
	}

	public Serie getSerie() {
		return serie;
	}

	public void setSerie(Serie serie) {
		this.serie = serie;
	}

	public Set<Turma_disciplina> getTurma_disciplinas() {
		return turma_disciplinas;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id_turma);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Turma other = (Turma) obj;
		return Objects.equals(id_turma, other.id_turma);
	}
	
	
}
