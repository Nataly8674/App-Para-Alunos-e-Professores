package com.seducapp.gerenciadordeaulas.controllers;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.seducapp.gerenciadordeaulas.dto.ChamadaResponseDTO;
import com.seducapp.gerenciadordeaulas.dto.RealizarChamadaRequestDTO;
import com.seducapp.gerenciadordeaulas.services.ChamadaService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/chamadas")
@Tag(name = "Chamada Controller", description = "Endpoints para gerenciamento de chamadas")
public class ChamadaController {

    @Autowired
    private ChamadaService chamadaService;

    @PostMapping("/realizar")
    @PreAuthorize("hasRole('PROFESSOR')")
    @Operation(summary = "Realizar chamada", description = "Realiza a chamada para uma turma em um horário específico")
    public ResponseEntity<ChamadaResponseDTO> realizarChamada(
            @RequestBody @Valid RealizarChamadaRequestDTO chamadaRequest) {
        ChamadaResponseDTO response = chamadaService.realizarChamada(chamadaRequest);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/turma/{idTurma}")
    @Operation(summary = "Buscar chamadas por turma", description = "Retorna todas as chamadas de uma turma específica")
    public ResponseEntity<List<ChamadaResponseDTO>> buscarChamadasPorTurma(
            @PathVariable Long idTurma) {
        List<ChamadaResponseDTO> chamadas = chamadaService.buscarChamadasPorTurma(idTurma);
        return ResponseEntity.ok(chamadas);
    }

    @GetMapping("/horario/{idHorario}/data/{data}")
    @Operation(summary = "Verificar chamada existente", description = "Verifica se já existe chamada para um horário e data específicos")
    public ResponseEntity<Boolean> verificarChamadaExistente(@PathVariable Long idHorario, @PathVariable String data) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate localDate = LocalDate.parse(data, formatter);
        Boolean exists = chamadaService.verificarChamadaExistente(idHorario, localDate);
        return ResponseEntity.ok(exists);
    }

    @GetMapping("/aluno/{idAluno}")
    @Operation(summary = "Buscar presenças do aluno", 
               description = "Retorna o histórico de presenças de um aluno específico")
    public ResponseEntity<List<ChamadaResponseDTO>> buscarPresencasAluno(
            @PathVariable Long idAluno) {
        List<ChamadaResponseDTO> presencas = chamadaService.buscarPresencasAluno(idAluno);
        return ResponseEntity.ok(presencas);
    }
}
