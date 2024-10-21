package com.seducapp.gerenciadordeaulas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.seducapp.gerenciadordeaulas.model.Turma;

public interface TurmaRepository extends JpaRepository<Turma, Long>{
}
