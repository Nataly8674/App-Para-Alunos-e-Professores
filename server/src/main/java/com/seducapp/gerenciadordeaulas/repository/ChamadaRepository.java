package com.seducapp.gerenciadordeaulas.repository;

import java.time.LocalDate;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.seducapp.gerenciadordeaulas.model.Chamada;

public interface ChamadaRepository extends JpaRepository<Chamada, Long> {
    @Query("SELECT COUNT(c) > 0 FROM Chamada c WHERE c.horario.id_horario = :horarioId AND c.data = :data")
    boolean existsByHorarioIdAndData(@Param("horarioId") Long horarioId, @Param("data") LocalDate data);
}
