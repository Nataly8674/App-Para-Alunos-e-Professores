package com.seducapp.gerenciadordeaulas.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.seducapp.gerenciadordeaulas.dto.ConteudoMinistradoRequestDTO;
import com.seducapp.gerenciadordeaulas.dto.ConteudoMinistradoResponseDTO;
import com.seducapp.gerenciadordeaulas.model.Conteudo_ministrado;
import com.seducapp.gerenciadordeaulas.model.Horario;
import com.seducapp.gerenciadordeaulas.repository.Conteudo_ministradoRepository;
import com.seducapp.gerenciadordeaulas.repository.HorarioRepository;
import com.seducapp.gerenciadordeaulas.services.exceptions.ResourceNotFoundException;

@Service
public class Conteudo_ministradoService {
    
    @Autowired
    private Conteudo_ministradoRepository conteudoRepository;
    
    @Autowired
    private HorarioRepository horarioRepository;
    
    @Transactional(readOnly = true)
    public List<ConteudoMinistradoResponseDTO> findAll() {
        return conteudoRepository.findAll().stream()
            .map(this::toResponseDTO)
            .collect(Collectors.toList());
    }
    
    @Transactional(readOnly = true)
    public ConteudoMinistradoResponseDTO findById(Long id) {
        Conteudo_ministrado conteudo = conteudoRepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Conteúdo não encontrado"));
        return toResponseDTO(conteudo);
    }
    
    @Transactional
    public ConteudoMinistradoResponseDTO create(ConteudoMinistradoRequestDTO dto) {
        Conteudo_ministrado conteudo = new Conteudo_ministrado();
        Horario horario = horarioRepository.findById(dto.getHorarioId())
            .orElseThrow(() -> new ResourceNotFoundException("Horário não encontrado"));
            
        conteudo.setDescricao(dto.getDescricao());
        conteudo.setData(dto.getData());
        conteudo.setHorario(horario);
        
        conteudo = conteudoRepository.save(conteudo);
        return toResponseDTO(conteudo);
    }
    
    @Transactional
    public ConteudoMinistradoResponseDTO update(Long id, ConteudoMinistradoRequestDTO dto) {
        Conteudo_ministrado conteudo = conteudoRepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Conteúdo não encontrado"));
            
        Horario horario = horarioRepository.findById(dto.getHorarioId())
            .orElseThrow(() -> new ResourceNotFoundException("Horário não encontrado"));
            
        conteudo.setDescricao(dto.getDescricao());
        conteudo.setData(dto.getData());
        conteudo.setHorario(horario);
        
        conteudo = conteudoRepository.save(conteudo);
        return toResponseDTO(conteudo);
    }
    
    @Transactional
    public void delete(Long id) {
        if (!conteudoRepository.existsById(id)) {
            throw new ResourceNotFoundException("Conteúdo não encontrado");
        }
        conteudoRepository.deleteById(id);
    }
    
    private ConteudoMinistradoResponseDTO toResponseDTO(Conteudo_ministrado conteudo) {
        return new ConteudoMinistradoResponseDTO(
            conteudo.getId_conteudo(),
            conteudo.getDescricao(),
            conteudo.getData(),
            conteudo.getHorario().getDia_semana().toString(),
            conteudo.getHorario().getHora_inicio(),
            conteudo.getHorario().getHora_fim()
        );
    }
}