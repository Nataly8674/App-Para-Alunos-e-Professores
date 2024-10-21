package com.seducapp.gerenciadordeaulas.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.seducapp.gerenciadordeaulas.enums.ModalidadesEnum;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "modalidades")
public class Modalidades implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_modalidade;

    @Enumerated(EnumType.STRING)
    @Column(name = "tipo")
    private ModalidadesEnum tipo;

    @OneToMany(mappedBy = "modalidade")
    @JsonIgnore
    private List<Turma> turma = new ArrayList<>();

    public Modalidades() {}

    public Modalidades(Long id_modalidade, String tipo) {
        this.id_modalidade = id_modalidade;
        this.tipo = ModalidadesEnum.fromString(tipo);
    }

    public Long getId_modalidade() {
        return id_modalidade;
    }

    public void setId_modalidade(Long id_modalidade) {
        this.id_modalidade = id_modalidade;
    }

    public ModalidadesEnum getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = ModalidadesEnum.fromString(tipo);
    }

    public List<Turma> getTurma() {
        return turma;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id_modalidade);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if (getClass() != obj.getClass()) return false;
        Modalidades other = (Modalidades) obj;
        return Objects.equals(id_modalidade, other.id_modalidade);
    }
}
