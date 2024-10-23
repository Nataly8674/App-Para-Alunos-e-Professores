package com.seducapp.gerenciadordeaulas.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.seducapp.gerenciadordeaulas.model.Modalidades;
import com.seducapp.gerenciadordeaulas.repository.ModalidadesRepository;

@Service
public class ModalidadesService {

    @Autowired
    private ModalidadesRepository modalidadesRepository;

    // Retorna todas as modalidades cadastradas
    public List<Modalidades> findAll() {
        return modalidadesRepository.findAll();
    }
    
    // Retorna uma modalidade pelo ID
    public Modalidades findById(Long id_modalidade) {
        return modalidadesRepository.findById(id_modalidade).orElse(null);
    }

    // Registra ou atualiza uma modalidade
    public Modalidades save(Modalidades modalidade) {
        return modalidadesRepository.save(modalidade);
    }

    // Remove uma modalidade pelo ID
    public void delete(Long id_modalidade) {
        modalidadesRepository.deleteById(id_modalidade);
    }
}

