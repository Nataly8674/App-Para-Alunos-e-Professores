package com.seducapp.gerenciadordeaulas.services;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.seducapp.gerenciadordeaulas.dto.HorarioDTO;
import com.seducapp.gerenciadordeaulas.model.Horario;
import com.seducapp.gerenciadordeaulas.repository.HorarioRepository;
import com.seducapp.gerenciadordeaulas.repository.AlunoRepository;
import com.seducapp.gerenciadordeaulas.repository.ProfessorRepository;

@Service
public class HorarioService {

    @Autowired
    private HorarioRepository horarioRepository;
    
    @Autowired
    private AlunoRepository alunoRepository;
    
    @Autowired
    private ProfessorRepository professorRepository;

 // Retorna todos os horários cadastrados
    public List<Horario> findAll() {
        return horarioRepository.findAll();
    }

    // Retorna um horário pelo ID
    public Horario findById(Long id_horario) {
        return horarioRepository.findById(id_horario).orElse(null);
    }

    // Registra ou atualiza um horário
    public Horario save(Horario horario) {
        return horarioRepository.save(horario);
    }

    // Remove um horário pelo ID
    public void delete(Long id_horario) {
        horarioRepository.deleteById(id_horario);
    }

    public List<HorarioDTO> buscarHorariosAluno(Long alunoId) {
        if (!alunoRepository.existsById(alunoId)) {
            throw new RuntimeException("Aluno não encontrado");
        }
        
        List<Horario> horarios = horarioRepository.findHorariosByAlunoId(alunoId);
        return converterParaDTO(horarios);
    }

    public List<HorarioDTO> buscarHorariosProfessor(Long professorId) {
        if (!professorRepository.existsById(professorId)) {
            throw new RuntimeException("Professor não encontrado");
        }
        
        List<Horario> horarios = horarioRepository.findHorariosByProfessorId(professorId);
        return converterParaDTO(horarios);
    }

    private List<HorarioDTO> converterParaDTO(List<Horario> horarios) {
        return horarios.stream()
            .map(horario -> {
                HorarioDTO dto = new HorarioDTO();
                dto.setId_horario(horario.getId_horario());
                dto.setDia_semana(horario.getDia_semana());
                dto.setHora_inicio(horario.getHora_inicio());
                dto.setHora_fim(horario.getHora_fim());
                dto.setDisciplina(horario.getTurma_disciplina().getDisciplina().getNome_disciplina());
                dto.setTurma(horario.getTurma_disciplina().getTurma().getNome_turma());
                dto.setProfessor(horario.getTurma_disciplina().getProfessor().getNome());
                return dto;
            })
            .collect(Collectors.toList());
        
    }
}