package com.seducapp.gerenciadordeaulas.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.seducapp.gerenciadordeaulas.dto.HorarioDTO;
import com.seducapp.gerenciadordeaulas.services.HorarioService;

@RestController
@RequestMapping("/api/horarios")
public class HorarioController {

    @Autowired
    private HorarioService horarioService;

    @GetMapping("/aluno/{alunoId}")
    public ResponseEntity<List<HorarioDTO>> buscarHorariosAluno(@PathVariable Long alunoId) {
        try {
            List<HorarioDTO> horarios = horarioService.buscarHorariosAluno(alunoId);
            return ResponseEntity.ok(horarios);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/professor/{professorId}")
    public ResponseEntity<List<HorarioDTO>> buscarHorariosProfessor(@PathVariable Long professorId) {
        try {
            List<HorarioDTO> horarios = horarioService.buscarHorariosProfessor(professorId);
            return ResponseEntity.ok(horarios);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }
}