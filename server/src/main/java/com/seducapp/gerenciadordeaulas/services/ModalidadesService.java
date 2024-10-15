package com.seducapp.gerenciadordeaulas.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.seducapp.gerenciadordeaulas.model.Modalidades;
import com.seducapp.gerenciadordeaulas.repository.ModalidadesRepository;

@Service
public class ModalidadesService {

	@Autowired
	private ModalidadesRepository modalidades;
	
	public List<Modalidades> findall() {
		return modalidades.findAll();
	}
}
