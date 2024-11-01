package com.seducapp.gerenciadordeaulas.model;

import java.io.Serializable;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.seducapp.gerenciadordeaulas.enums.Dia_semana;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinColumns;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
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
	
	@OneToMany(mappedBy = "horario")
	@JsonIgnore
	private List <Conteudo_ministrado> conteudos = new ArrayList<>();
	
	@OneToMany(mappedBy = "horario")
	@JsonIgnore
	private List<Chamada> chamadas = new ArrayList<>();
	
	@ManyToOne
    @JoinColumns({
        @JoinColumn(name = "id_turma", referencedColumnName = "id_turma"),
        @JoinColumn(name = "id_disciplina", referencedColumnName = "id_disciplina")
    })
    private Turma_disciplina turma_disciplina;
	
	public Horario() {
		
	}
	
	public Horario(Long id_horario, String dia_semana, LocalTime hora_inicio, LocalTime hora_fim, Turma_disciplina turma_disciplina) {
		this.id_horario = id_horario;
		this.dia_semana = Dia_semana.fromString(dia_semana);
		this.hora_inicio = hora_inicio;
		this.hora_fim = hora_fim;
		this.turma_disciplina = turma_disciplina;
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

	public void setDia_semana(String dia_semana) {
		this.dia_semana = Dia_semana.fromString(dia_semana);
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
	

	public Turma_disciplina getTurma_disciplina() {
		return turma_disciplina;
	}

	public void setTurma_disciplina(Turma_disciplina turma_disciplina) {
		this.turma_disciplina = turma_disciplina;
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
