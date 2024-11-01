package com.seducapp.gerenciadordeaulas.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "chamada")
public class Chamada implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_chamada;
	private LocalDate data;
	private Character presença; 
	
	@ManyToOne
	@JoinColumn(name = "id_horario")
	private Horario horario;
	
	@ManyToMany(mappedBy = "chamadas")
	@JsonIgnore
	private Set<Aluno> alunos = new HashSet<>();
	
	public Chamada() {
		
	}
	
	public Chamada(Long id_chamada, LocalDate data, Horario horario) {
		this.id_chamada = id_chamada;
		this.data = data;
		this.horario = horario;
	}

	public Long getId_chamada() {
		return id_chamada;
	}

	public void setId_chamada(Long id_chamada) {
		this.id_chamada = id_chamada;
	}

	public LocalDate getData() {
		return data;
	}

	public void setData(LocalDate data) {
		this.data = data;
	}

	public Character getPresença() {
		return presença;
	}

	public void setPresença(Character presença) {
		this.presença = presença;
	}

	public Horario getHorario() {
		return horario;
	}

	public void setHorario(Horario horario) {
		this.horario = horario;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id_chamada);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Chamada other = (Chamada) obj;
		return Objects.equals(id_chamada, other.id_chamada);
	}
	
	
}
