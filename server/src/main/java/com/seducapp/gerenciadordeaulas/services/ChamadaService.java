package com.seducapp.gerenciadordeaulas.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.seducapp.gerenciadordeaulas.model.Chamada;
import com.seducapp.gerenciadordeaulas.repository.ChamadaRepository;

@Service
public class ChamadaService {

	@Autowired
	private ChamadaRepository chamada;

	public List<Chamada> findall() {
		return chamada.findAll();
	}
}
