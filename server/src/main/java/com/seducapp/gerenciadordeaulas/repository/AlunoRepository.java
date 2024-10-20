package com.seducapp.gerenciadordeaulas.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.seducapp.gerenciadordeaulas.model.Aluno;

public interface AlunoRepository extends JpaRepository<Aluno, Long>{
}
