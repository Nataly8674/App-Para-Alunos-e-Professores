package com.seducapp.gerenciadordeaulas.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.seducapp.gerenciadordeaulas.enums.Tipo_usuario;

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
@Table(name = "usuarios")
public class Usuario implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_usuario;
	private String nome;
	private String email;
	private String senha;
	private String cpf;
	@Enumerated(EnumType.STRING)
    @Column(name = "tipo_usuario")
	private Tipo_usuario tipo_usuario;
	
	@OneToMany(mappedBy = "usuario")
	private  List<Aluno> alunos = new ArrayList<>();
	
	@OneToMany(mappedBy = "usuario")
	private List<Professor> professores = new ArrayList<>();
	
	public Usuario() {
		
	}

	public Usuario(Long id_usuario, String nome, String email, String senha, String tipo_usuario) {
		this.id_usuario = id_usuario;
		this.nome = nome;
		this.email = email;
		this.senha = senha;
		this.tipo_usuario = Tipo_usuario.fromString(tipo_usuario);
	}

	public Long getId_usuario() {
		return id_usuario;
	}

	public void setId_usuario(Long id_usuario) {
		this.id_usuario = id_usuario;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public Tipo_usuario getTipo_usuario() {
		return tipo_usuario;
	}

	public void setTipo_usuario(String tipo_usuario) {
		this.tipo_usuario = Tipo_usuario.fromString(tipo_usuario);
	}
	
	public List<Aluno> getAlunos() {
		return alunos;
	}

	public List<Professor> getProfessores() {
		return professores;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id_usuario);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Usuario other = (Usuario) obj;
		return Objects.equals(id_usuario, other.id_usuario);
	}

	public String getPassword() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
