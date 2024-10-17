package com.seducapp.gerenciadordeaulas.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.seducapp.gerenciadordeaulas.enums.ModalidadesEnum;

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
@Table(name = "modalidades")
public class Modalidades implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_modalidade;
	@Enumerated(EnumType.STRING)
    @Column(name = "tipo")
	private ModalidadesEnum tipo;
	
	@OneToMany(mappedBy = "modalidade")
	private List<Turma> turma = new ArrayList<>();
	
	
	public Modalidades() {
		
	}

	public Modalidades(Long id_modalidade, ModalidadesEnum tipo) {
		this.id_modalidade = id_modalidade;
		this.tipo = tipo;
	}

	public Long getId_modalidade() {
		return id_modalidade;
	}

	public void setId_modalidades(Long id_modalidades) {
		this.id_modalidade = id_modalidades;
	}

	public ModalidadesEnum getTipo() {
		return tipo;
	}

	public void setTipo(ModalidadesEnum tipo_modalidades) {
		this.tipo= tipo_modalidades;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id_modalidade);
	}

	public List<Turma> getTurma() {
		return turma;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Modalidades other = (Modalidades) obj;
		return Objects.equals(id_modalidade, other.id_modalidade);
	}
	
	
}
