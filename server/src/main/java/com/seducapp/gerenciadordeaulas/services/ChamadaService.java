package com.seducapp.gerenciadordeaulas.services;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.seducapp.gerenciadordeaulas.dto.*;
import com.seducapp.gerenciadordeaulas.model.*;
import com.seducapp.gerenciadordeaulas.repository.*;
import jakarta.persistence.EntityNotFoundException;

@Service
public class ChamadaService {

    @Autowired
    private ChamadaRepository chamadaRepository;
    
    @Autowired
    private HorarioRepository horarioRepository;
    
    @Autowired
    private AlunoRepository alunoRepository;

    @Transactional
    public ChamadaResponseDTO realizarChamada(RealizarChamadaRequestDTO dto) {
        // Busca o horário
        Horario horario = horarioRepository.findById(dto.getIdHorario())
            .orElseThrow(() -> new EntityNotFoundException("Horário não encontrado"));

        // Cria uma nova chamada
        Chamada chamada = new Chamada();
        chamada.setData(dto.getData());
        chamada.setHorario(horario);
        
        // Salva a chamada
        chamada = chamadaRepository.save(chamada);
        
        // Processa as presenças dos alunos
        List<AlunoPresencaDTO> presencas = new ArrayList<>();
        
        for (PresencaAlunoDTO presencaDTO : dto.getPresencas()) {
            Aluno aluno = alunoRepository.findById(presencaDTO.getIdAluno())
                .orElseThrow(() -> new EntityNotFoundException("Aluno não encontrado"));
                
            // Atualiza a presença do aluno
            chamada.setPresença(presencaDTO.getPresenca());
            aluno.getChamadas().add(chamada);
            
            // Adiciona à lista de resposta
            AlunoPresencaDTO alunoPresencaDTO = new AlunoPresencaDTO();
            alunoPresencaDTO.setIdAluno(aluno.getId_aluno());
            alunoPresencaDTO.setNomeAluno(aluno.getNome());
            alunoPresencaDTO.setPresenca(presencaDTO.getPresenca());
            presencas.add(alunoPresencaDTO);
        }
        
        // Cria o DTO de resposta
        ChamadaResponseDTO response = new ChamadaResponseDTO();
        response.setIdChamada(chamada.getId_chamada());
        response.setData(chamada.getData());
        response.setTurma(horario.getTurma_disciplina().getTurma().getNome_turma());
        response.setDisciplina(horario.getTurma_disciplina().getDisciplina().getNome_disciplina());
        response.setPresencas(presencas);
        
        return response;
    }

    @Transactional(readOnly = true)
    public List<ChamadaResponseDTO> buscarChamadasPorTurma(Long idTurma) {
        // Implementação da busca de chamadas por turma
        return chamadaRepository.findAll().stream()
            .filter(c -> c.getHorario().getTurma_disciplina().getTurma().getId_turma().equals(idTurma))
            .map(this::convertToChamadaResponseDTO)
            .collect(Collectors.toList());
    }

    private ChamadaResponseDTO convertToChamadaResponseDTO(Chamada chamada) {
        ChamadaResponseDTO dto = new ChamadaResponseDTO();
        dto.setIdChamada(chamada.getId_chamada());
        dto.setData(chamada.getData());
        dto.setTurma(chamada.getHorario().getTurma_disciplina().getTurma().getNome_turma());
        dto.setDisciplina(chamada.getHorario().getTurma_disciplina().getDisciplina().getNome_disciplina());
        // Implementar conversão das presenças
        return dto;
    }
}