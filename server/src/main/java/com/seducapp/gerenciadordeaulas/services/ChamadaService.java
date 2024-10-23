package com.seducapp.gerenciadordeaulas.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.seducapp.gerenciadordeaulas.model.Chamada;
import com.seducapp.gerenciadordeaulas.repository.ChamadaRepository;

@Service
public class ChamadaService {

    @Autowired
    private ChamadaRepository chamadaRepository;

    // Retorna todas as chamadas cadastradas
    public List<Chamada> findAll() {
        return chamadaRepository.findAll();
    }

    // Retorna uma chamada pelo ID
    public Chamada findById(Long id) {
        return chamadaRepository.findById(id).orElse(null);
    }

    // Registra ou atualiza uma chamada
    public Chamada save(Chamada chamada) {
        return chamadaRepository.save(chamada);
    }

    // Remove uma chamada pelo ID
    public void delete(Long id) {
        chamadaRepository.deleteById(id);
    }
}
