package com.seducapp.gerenciadordeaulas.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.seducapp.gerenciadordeaulas.model.Horario;
import com.seducapp.gerenciadordeaulas.repository.HorarioRepository;

@Service
public class HorarioService {

	@Autowired
	private HorarioRepository horario;
	
	public List<Horario> findall() {
		return horario.findAll();
	}
}
