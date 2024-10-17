package com.seducapp.gerenciadordeaulas.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.seducapp.gerenciadordeaulas.model.Conteudo_ministrado;
import com.seducapp.gerenciadordeaulas.repository.Conteudo_ministradoRepository;

@Service
public class Conteudo_ministradoService {
	
	@Autowired
	private Conteudo_ministradoRepository conteudo_ministrado;
	
	public List<Conteudo_ministrado> findall() {
		return conteudo_ministrado.findAll();
	}
}
