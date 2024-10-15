package com.seducapp.gerenciadordeaulas.model;

import java.io.Serializable;
import java.time.LocalTime;
import java.util.Objects;

import com.seducapp.gerenciadordeaulas.enums.Dia_semana;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "horario")
public class Horario implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_horario;
	@Enumerated(EnumType.STRING)
    @Column(name = "dia_semana")
	private Dia_semana dia_semana;
	private LocalTime hora_inicio;
	private LocalTime hora_fim;
	
	public Horario() {
		
	}
	
	public Horario(Long id_horario, Dia_semana dia_semana, LocalTime hora_inicio, LocalTime hora_fim) {
		this.id_horario = id_horario;
		this.dia_semana = dia_semana;
		this.hora_inicio = hora_inicio;
		this.hora_fim = hora_fim;
	}

	public Long getId_horario() {
		return id_horario;
	}

	public void setId_horario(Long id_horario) {
		this.id_horario = id_horario;
	}

	public Dia_semana getDia_semana() {
		return dia_semana;
	}

	public void setDia_semana(Dia_semana dia_semana) {
		this.dia_semana = dia_semana;
	}

	public LocalTime getHora_inicio() {
		return hora_inicio;
	}

	public void setHora_inicio(LocalTime hora_inicio) {
		this.hora_inicio = hora_inicio;
	}

	public LocalTime getHora_fim() {
		return hora_fim;
	}

	public void setHora_fim(LocalTime hora_fim) {
		this.hora_fim = hora_fim;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id_horario);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Horario other = (Horario) obj;
		return Objects.equals(id_horario, other.id_horario);
	}
	
	

}
