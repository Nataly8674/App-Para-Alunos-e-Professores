package com.seducapp.gerenciadordeaulas.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.seducapp.gerenciadordeaulas.model.Serie;
import com.seducapp.gerenciadordeaulas.repository.SerieRepository;

@Service
public class SerieService {

	@Autowired
	private SerieRepository serie;
	
	public List<Serie> findall() {
		return serie.findAll();	
	}
}
