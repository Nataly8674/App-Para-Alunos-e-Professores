package com.seducapp.gerenciadordeaulas.services;

import com.seducapp.gerenciadordeaulas.model.Disciplina;
import com.seducapp.gerenciadordeaulas.repository.DisciplinaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DisciplinaService {

    @Autowired
    private DisciplinaRepository disciplinaRepository;

    // Método para buscar todas as disciplinas
    public List<Disciplina> findAll() {
        return disciplinaRepository.findAll();
    }

    // Método para buscar disciplina por ID
    public Optional<Disciplina> findById(Long id) {
        return disciplinaRepository.findById(id);
    }

    // Método para salvar uma nova disciplina
    public Disciplina save(Disciplina disciplina) {
        return disciplinaRepository.save(disciplina);
    }

    // Método para atualizar uma disciplina existente
    public Disciplina update(Long id, Disciplina disciplinaAtualizada) {
        disciplinaAtualizada.setId_disciplina(id);;
        return disciplinaRepository.save(disciplinaAtualizada);
    }

    /// Método para deletar uma disciplina
    public void delete(Long id) {
        disciplinaRepository.deleteById(id);
    }
}

