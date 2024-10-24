package com.seducapp.gerenciadordeaulas.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.seducapp.gerenciadordeaulas.model.Turma_disciplina;
import com.seducapp.gerenciadordeaulas.model.pk.Turma_disciplinaPk;
import com.seducapp.gerenciadordeaulas.repository.Turma_disciplinaRepository;

@Service
public class Turma_disciplinaService {

	@Autowired
	private Turma_disciplinaRepository turma_disciplinaRepository;
	
	public Turma_disciplina findById(Turma_disciplinaPk pk) {
		Optional<Turma_disciplina> t1 = turma_disciplinaRepository.findById(pk);
		return t1.get();
	}
}
