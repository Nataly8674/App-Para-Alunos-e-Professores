package com.seducapp.gerenciadordeaulas.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "alunos")
public class Aluno implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_aluno;
	private String nome;
	private String endereço;
	private String telefone;
	
	@ManyToOne
	@JoinColumn(name = "id_usuario")
	private Usuario usuario;
	
	@ManyToOne
	@JoinColumn(name = "id_turma")
	private Turma turma;
	
	@ManyToMany
	@JoinTable(name = "Aluno_chamada", joinColumns = @JoinColumn(name = "id_aluno"),
	inverseJoinColumns = @JoinColumn(name = "id_chamada"))
	private Set<Chamada> chamadas = new HashSet<>();
	
	public Aluno() {
		
	}
	
	public Aluno(Long id_aluno, String nome, String endereço, String telefone, Usuario usuario, Turma turma) {
		this.id_aluno = id_aluno;
		this.nome = nome;
		this.endereço = endereço;
		this.telefone = telefone;
		this.usuario = usuario;
		this.turma = turma;
	}

	public Long getId_aluno() {
		return id_aluno;
	}

	public void setId_aluno(Long id_aluno) {
		this.id_aluno = id_aluno;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEndereço() {
		return endereço;
	}

	public void setEndereço(String endereço) {
		this.endereço = endereço;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Turma getTurma() {
		return turma;
	}

	public void setTurma(Turma turma) {
		this.turma = turma;
	}

	public Set<Chamada> getChamadas() {
		return chamadas;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id_aluno);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Aluno other = (Aluno) obj;
		return Objects.equals(id_aluno, other.id_aluno);
	}
	
	
}
