package com.seducapp.gerenciadordeaulas.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.seducapp.gerenciadordeaulas.model.Serie;
import com.seducapp.gerenciadordeaulas.repository.SerieRepository;

@Service
public class SerieService {

    @Autowired
    private SerieRepository serieRepository;

    // Retorna todas as séries cadastradas
    public List<Serie> findAll() {
        return serieRepository.findAll();
    }

    // Retorna uma série pelo ID
    public Serie findById(Long id_serie) {
        return serieRepository.findById(id_serie).orElse(null);
    }

    // Remove uma série pelo ID
    public Serie save(Serie serie) {
        return serieRepository.save(serie);
    }

    // Remove uma série pelo ID
    public void delete(Long id_serie) {
        serieRepository.deleteById(id_serie);
    }
}

