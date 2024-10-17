package com.seducapp.gerenciadordeaulas.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.seducapp.gerenciadordeaulas.model.Professor;

public interface ProfessorRepository extends JpaRepository<Professor, Long>{

}
