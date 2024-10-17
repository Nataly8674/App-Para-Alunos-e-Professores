package com.seducapp.gerenciadordeaulas.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.seducapp.gerenciadordeaulas.model.Turma_disciplina;
import com.seducapp.gerenciadordeaulas.model.pk.Turma_disciplinaPk;

public interface Turma_disciplinaRepository extends JpaRepository<Turma_disciplina, Turma_disciplinaPk>{

}
