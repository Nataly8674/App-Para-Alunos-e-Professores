package com.seducapp.gerenciadordeaulas.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.seducapp.gerenciadordeaulas.model.Turma;
import com.seducapp.gerenciadordeaulas.repository.TurmaRepository;

@Service
public class TurmaService {

    @Autowired
    private TurmaRepository turmaRepository;
    
    public Turma findById(Long id) {
    	Optional<Turma> t1 = turmaRepository.findById(id);
    	return t1.get();
    }

   
}

