package com.seducapp.gerenciadordeaulas.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.seducapp.gerenciadordeaulas.model.Turma;
import com.seducapp.gerenciadordeaulas.repository.TurmaRepository;

@Service
public class TurmaService {

	@Autowired
	private TurmaRepository turma;
	
	public List<Turma> findall() {
		return turma.findAll();
	}
}
