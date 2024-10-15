package com.seducapp.gerenciadordeaulas.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.seducapp.gerenciadordeaulas.model.Usuario;
import com.seducapp.gerenciadordeaulas.repository.UsuarioRepository;

@Service
public class UsuarioService {
	
	@Autowired
	private UsuarioRepository usuario;
	
	public List<Usuario> findall() {
		return usuario.findAll();
	}
}
