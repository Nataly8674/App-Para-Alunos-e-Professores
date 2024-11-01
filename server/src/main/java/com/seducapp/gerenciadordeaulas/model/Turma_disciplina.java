package com.seducapp.gerenciadordeaulas.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;


@Entity
@Table(name = "turma_disciplina")
@IdClass(TurmaDisciplinaId.class)
public class Turma_disciplina implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
    @Column(name = "id_turma")
    private Long id_turma;
    
    @Id
    @Column(name = "id_disciplina")
    private Long id_disciplina;
    
    @ManyToOne
    @JoinColumn(name = "id_turma", insertable = false, updatable = false)
    private Turma turma;
    
    @ManyToOne
    @JoinColumn(name = "id_disciplina", insertable = false, updatable = false)
    private Disciplina disciplina;
    
    @OneToMany(mappedBy = "turma_disciplina")
    @JsonIgnore
    private List<Horario> horarios = new ArrayList<>();
	
	@ManyToOne
    @JoinColumn(name = "id_Professor")
    private Professor professor;

	public Turma_disciplina() {
    }

    public Turma_disciplina(Turma turma, Disciplina disciplina) {
        this.turma = turma;
        this.disciplina = disciplina;
        this.id_turma = turma.getId_turma();
        this.id_disciplina = disciplina.getId_disciplina();
    }

    // Getters e Setters
    public Long getId_turma() {
        return id_turma;
    }

    public void setId_turma(Long id_turma) {
        this.id_turma = id_turma;
    }

    public Long getId_disciplina() {
        return id_disciplina;
    }

    public void setId_disciplina(Long id_disciplina) {
        this.id_disciplina = id_disciplina;
    }

    public Turma getTurma() {
        return turma;
    }

    public void setTurma(Turma turma) {
        this.turma = turma;
        this.id_turma = turma != null ? turma.getId_turma() : null;
    }

    public Disciplina getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(Disciplina disciplina) {
        this.disciplina = disciplina;
        this.id_disciplina = disciplina != null ? disciplina.getId_disciplina() : null;
    }

	public Professor getProfessor() {
		return professor;
	}

	public void setProfessor(Professor professor) {
		this.professor = professor;
	}
    
    
}
