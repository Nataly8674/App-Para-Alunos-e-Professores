package com.seducapp.gerenciadordeaulas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.seducapp.gerenciadordeaulas.model.TurmaDisciplinaId;
import com.seducapp.gerenciadordeaulas.model.Turma_disciplina;

public interface Turma_disciplinaRepository extends JpaRepository<Turma_disciplina, TurmaDisciplinaId>{
}
