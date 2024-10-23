package com.seducapp.gerenciadordeaulas.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.seducapp.gerenciadordeaulas.model.Aluno;
import com.seducapp.gerenciadordeaulas.model.Turma;
import com.seducapp.gerenciadordeaulas.repository.TurmaRepository;

import jakarta.transaction.Transactional;

@Service
public class TurmaService {

    @Autowired
    private TurmaRepository turmaRepository;

    // Retorna todas as turmas cadastradas
    public List<Turma> findAll() {
        return turmaRepository.findAll();
    }

    // Retorna uma turma pelo ID
    public Turma findById(Long id_turma) {
        return turmaRepository.findById(id_turma)
            .orElseThrow(() -> new RuntimeException("Turma não encontrada com ID: " + id_turma));
    }

    // Registra ou atualiza uma turma
    public Turma save(Turma turma) {
        if (turma == null) {
            throw new IllegalArgumentException("A turma não pode ser nula.");
        }
        return turmaRepository.save(turma);
    }

    // Remove uma turma pelo ID
    public void delete(Long id_turma) {
        if (!turmaRepository.existsById(id_turma)) {
            throw new RuntimeException("Turma não encontrada com ID: " + id_turma);
        }
        turmaRepository.deleteById(id_turma);
    }

	@Transactional
	// Retorna a lista de alunos de uma turma específica
	public List<Aluno> getAlunosByTurmaId(Long id_turma) {
		Turma turma = turmaRepository.findById(id_turma).orElseThrow(() -> new RuntimeException("Turma não encontrada com esse id:" + id_turma));
		return turma.getAlunos();
	}
}

