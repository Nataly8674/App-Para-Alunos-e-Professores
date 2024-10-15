package com.seducapp.gerenciadordeaulas.config;

import org.springframework.boot.CommandLineRunner;

import com.seducapp.gerenciadordeaulas.services.UsuarioService;

public class TestConfig implements CommandLineRunner{
	
	private UsuarioService usuario;

	@Override
	public void run(String... args) throws Exception {
		System.out.println(usuario.findall());
	}

}
