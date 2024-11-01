package com.seducapp.gerenciadordeaulas.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.seducapp.gerenciadordeaulas.model.Aluno;
import com.seducapp.gerenciadordeaulas.model.Turma;
import com.seducapp.gerenciadordeaulas.repository.AlunoRepository;
import com.seducapp.gerenciadordeaulas.repository.TurmaRepository;

@Service
public class AlunoService {

    @Autowired
    private AlunoRepository alunoRepository;
    
    @Autowired
    private TurmaRepository turmaRepository;
    
    // Retorno de todos os alunos que foram cadastrados
    public List<Aluno> findAll() {
        return alunoRepository.findAll();
    }

    // Retorna um aluno pelo ID
    public Aluno findById(Long id_aluno) {
        return alunoRepository.findById(id_aluno).orElse(null);
    }

    // Registra ou atualiza um aluno
    public Aluno save(Aluno aluno) {
        return alunoRepository.save(aluno);
    }
    
    // Remove um aluno pelo ID
    public void delete(Long id_aluno) {
        alunoRepository.deleteById(id_aluno);
    }
}