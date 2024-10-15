package com.seducapp.gerenciadordeaulas.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.seducapp.gerenciadordeaulas.model.Aluno;
import com.seducapp.gerenciadordeaulas.repository.AlunoRepository;

@Service
public class AlunoService {
	
	@Autowired
	private AlunoRepository aluno;
	
	public List<Aluno> findall() {
		return aluno.findAll();
	}
}
