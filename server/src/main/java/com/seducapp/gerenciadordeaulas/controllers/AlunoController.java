package com.seducapp.gerenciadordeaulas.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.seducapp.gerenciadordeaulas.model.Aluno;
import com.seducapp.gerenciadordeaulas.model.Turma;
import com.seducapp.gerenciadordeaulas.services.AlunoService;

@RestController
@RequestMapping("/alunos")
public class AlunoController {
	
	@Autowired
	private AlunoService alunoService;
	
	@GetMapping("/{id}/turmas")
	public Turma findTurmaByAluno(@PathVariable Long id) {
		Aluno aluno = alunoService.findById(id);
		return alunoService.findTurmaByAluno(aluno);
	}
}
