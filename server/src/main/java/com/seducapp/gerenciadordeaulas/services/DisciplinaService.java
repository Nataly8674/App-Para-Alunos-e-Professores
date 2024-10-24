package com.seducapp.gerenciadordeaulas.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.seducapp.gerenciadordeaulas.model.Disciplina;
import com.seducapp.gerenciadordeaulas.repository.DisciplinaRepository;

@Service
public class DisciplinaService {

	@Autowired
	private DisciplinaRepository disciplinaRepository;
	
	public List<Disciplina> findall() {
		return disciplinaRepository.findAll();
	}
	
	public Disciplina findById(Long id) {
		Optional<Disciplina> d1 = disciplinaRepository.findById(id);
		return d1.get();
	}
}
