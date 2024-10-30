package com.seducapp.gerenciadordeaulas.dto;

import java.time.LocalTime;
import com.seducapp.gerenciadordeaulas.enums.Dia_semana;

public class HorarioDTO {
    private Long id_horario;
    private Dia_semana dia_semana;
    private LocalTime hora_inicio;
    private LocalTime hora_fim;
    private String disciplina;
    private String turma;
    private String professor;
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
	public String getDisciplina() {
		return disciplina;
	}
	public void setDisciplina(String disciplina) {
		this.disciplina = disciplina;
	}
	public String getTurma() {
		return turma;
	}
	public void setTurma(String turma) {
		this.turma = turma;
	}
	public String getProfessor() {
		return professor;
	}
	public void setProfessor(String professor) {
		this.professor = professor;
	}

    
}
