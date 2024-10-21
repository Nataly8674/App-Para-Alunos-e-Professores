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

    @Transactional
    public List<Aluno> getAlunosByTurmaId(Long turmaId) {
        Turma turma = turmaRepository.findById(turmaId).orElseThrow(() -> new RuntimeException("Turma não encontrada"));
        return turma.getAlunos();
    }
}

