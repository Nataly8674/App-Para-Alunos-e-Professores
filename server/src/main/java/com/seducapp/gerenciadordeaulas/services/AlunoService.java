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
	
	public List<Aluno> findall() {
		return alunoRepository.findAll();
	}
	
	public Aluno findById(Long id) {
		Optional<Aluno> aluno = alunoRepository.findById(id);
		return aluno.get();
	}
	
	public Turma findTurmaByAluno(Aluno aluno) {
		Optional<Turma> t1 = turmaRepository.findById(aluno.getTurma().getId_turma());
		return t1.get();
	}
}
