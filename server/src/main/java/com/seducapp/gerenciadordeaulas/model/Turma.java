package com.seducapp.gerenciadordeaulas.model;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "turma")
public class Turma implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_turma;
	private String nome_turma;
	
	public Turma() {
		
	}

	public Turma(Long id_turma, String nome_turma) {
		this.id_turma = id_turma;
		this.nome_turma = nome_turma;
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
