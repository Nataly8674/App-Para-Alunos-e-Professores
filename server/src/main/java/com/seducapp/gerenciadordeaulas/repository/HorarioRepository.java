package com.seducapp.gerenciadordeaulas.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import com.seducapp.gerenciadordeaulas.model.Horario;

public interface HorarioRepository extends JpaRepository<Horario, Long> {
    
    @Query("SELECT h FROM Horario h " +
           "JOIN h.turma_disciplina td " +
           "JOIN td.turma t " +
           "JOIN t.alunos a " +
           "WHERE a.id_aluno = :alunoId")
    List<Horario> findHorariosByAlunoId(@Param("alunoId") Long alunoId);

    @Query("SELECT h FROM Horario h " +
           "JOIN h.turma_disciplina td " +
           "WHERE td.professor.id_professor = :professorId")
    List<Horario> findHorariosByProfessorId(@Param("professorId") Long professorId);
}