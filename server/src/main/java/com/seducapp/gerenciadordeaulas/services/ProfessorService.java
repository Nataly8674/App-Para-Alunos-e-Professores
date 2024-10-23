package com.seducapp.gerenciadordeaulas.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.seducapp.gerenciadordeaulas.model.Professor;
import com.seducapp.gerenciadordeaulas.repository.ProfessorRepository;

@Service
public class ProfessorService {

    @Autowired
    private ProfessorRepository professorRepository;

    // Retorna todos os professores cadastrados
    public List<Professor> findAll() {
        return professorRepository.findAll();
    }

    // Retorna um professor pelo ID
    public Professor findById(Long id_professor) {
        return professorRepository.findById(id_professor).orElse(null);
    }

    // Registra ou atualiza um professor
    public Professor save(Professor professor) {
        return professorRepository.save(professor);
    }

    // Remove um professor pelo ID
    public void delete(Long id_professor) {
        professorRepository.deleteById(id_professor);
    }
}
