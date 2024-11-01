package com.seducapp.gerenciadordeaulas.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.seducapp.gerenciadordeaulas.enums.Grau_ensino;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "serie")
public class Serie implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_serie;
	private Integer numero_serie;
	@Enumerated(EnumType.STRING)
	@Column(name = "grau_ensino")
	private Grau_ensino grau_ensino;
	
	@OneToMany(mappedBy = "serie")
	@JsonIgnore
	private List<Turma> turma = new ArrayList<>();
	
	public Serie() {
		
	}


	public Serie(Long id_serie, Integer numero_serie, String grau_ensino) {
		this.id_serie = id_serie;
		this.numero_serie = numero_serie;
		this.grau_ensino = Grau_ensino.fromString(grau_ensino);
	}


	public Long getId_serie() {
		return id_serie;
	}


	public void setId_serie(Long id_serie) {
		this.id_serie = id_serie;
	}


	public Integer getNumero_serie() {
		return numero_serie;
	}


	public void setNumero_serie(Integer numero_serie) {
		this.numero_serie = numero_serie;
	}


	public Grau_ensino getGrau_ensino() {
		return grau_ensino;
	}


	public void setGrau_ensino(String grau_ensino) {
		this.grau_ensino = Grau_ensino.fromString(grau_ensino);
	}

	public List<Turma> getTurma() {
		return turma;
	}


	@Override
	public int hashCode() {
		return Objects.hash(id_serie);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Serie other = (Serie) obj;
		return Objects.equals(id_serie, other.id_serie);
	}
	
	
}
