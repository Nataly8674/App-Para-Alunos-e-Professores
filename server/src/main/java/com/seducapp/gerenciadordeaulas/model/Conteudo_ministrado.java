package com.seducapp.gerenciadordeaulas.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "conteudo_ministrado")
public class Conteudo_ministrado implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_conteudo;
	private LocalDate data;
	private String descricao;
	
	@ManyToOne
	@JoinColumn(name = "id_horario")
	private Horario horario;
	
	public Conteudo_ministrado() {
		
	}

	public Conteudo_ministrado(Long id_conteudo, LocalDate data, String descricao, Horario horario) {
		this.id_conteudo = id_conteudo;
		this.data = data;
		this.descricao = descricao;
		this.horario = horario;
	}

	public Long getId_conteudo() {
		return id_conteudo;
	}

	public void setId_conteudo(Long id_conteudo) {
		this.id_conteudo = id_conteudo;
	}

	public LocalDate getData() {
		return data;
	}

	public void setData(LocalDate data) {
		this.data = data;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Horario getHorario() {
		return horario;
	}

	public void setHorario(Horario horario) {
		this.horario = horario;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id_conteudo);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Conteudo_ministrado other = (Conteudo_ministrado) obj;
		return Objects.equals(id_conteudo, other.id_conteudo);
	}
	
	
}
