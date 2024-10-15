package com.seducapp.gerenciadordeaulas.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.seducapp.gerenciadordeaulas.model.Disciplina;
import com.seducapp.gerenciadordeaulas.repository.DisciplinaRepository;

@Service
public class DisciplinaService {

	@Autowired
	private DisciplinaRepository disciplina;
	
	public List<Disciplina> findall() {
		return disciplina.findAll();
	}
}
