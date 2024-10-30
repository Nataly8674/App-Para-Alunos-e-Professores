package com.seducapp.gerenciadordeaulas.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

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
public class Usuario implements Serializable, UserDetails {
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
    private List<Aluno> alunos = new ArrayList<>();

    @OneToMany(mappedBy = "usuario")
    private List<Professor> professores = new ArrayList<>();

    public Usuario() {
    }

    public Usuario(Long id_usuario, String nome, String email, String senha, String tipo_usuario) {
        this.id_usuario = id_usuario;
        this.nome = nome;
        this.email = email;
        setSenha(senha); // Armazenando a senha corretamente
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
        // Se você desejar criptografar a senha antes de armazenar, utilize BCrypt
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        this.senha = encoder.encode(senha); // Criptografa a senha antes de armazenar
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
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Usuario other = (Usuario) obj;
        return Objects.equals(id_usuario, other.id_usuario);
    }

    // Implementação dos métodos da interface UserDetails

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        // Aqui você pode adicionar as permissões do usuário, se aplicável
        return null; // Atualize conforme necessário
    }

    @Override
    public String getPassword() {
        return this.senha; // Retorna a senha para validação
    }

    @Override
    public String getUsername() {
        return this.email; // Pode usar o CPF ou email como identificador do usuário
    }

    @Override
    public boolean isAccountNonExpired() {
        return true; // Implementar lógica de expiração de conta, se aplicável
    }

    @Override
    public boolean isAccountNonLocked() {
        return true; // Implementar lógica de bloqueio de conta, se aplicável
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true; // Implementar lógica de expiração de credenciais, se aplicável
    }

    @Override
    public boolean isEnabled() {
        return true; // Implementar lógica para desativar contas, se aplicável
    }
}
