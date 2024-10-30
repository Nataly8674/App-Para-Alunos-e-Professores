package com.seducapp.gerenciadordeaulas.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.seducapp.gerenciadordeaulas.model.Usuario;
import com.seducapp.gerenciadordeaulas.repository.UsuarioRepository;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    // Busca um usuário pelo CPF
    public Usuario findByCpf(String cpf) {
        return usuarioRepository.findByCpf(cpf);
    }
}


