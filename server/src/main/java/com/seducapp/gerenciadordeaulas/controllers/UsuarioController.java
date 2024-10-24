package com.seducapp.gerenciadordeaulas.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.seducapp.gerenciadordeaulas.model.Usuario;
import com.seducapp.gerenciadordeaulas.services.UsuarioService;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {
	
	@Autowired
	private UsuarioService usuarioService;
	
	@GetMapping("/{cpf}")
	public Usuario findByCpf(@PathVariable String cpf) {
		return usuarioService.findByCpf(cpf);
	}
}
