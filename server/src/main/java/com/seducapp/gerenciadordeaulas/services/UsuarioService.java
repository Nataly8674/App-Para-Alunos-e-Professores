package com.seducapp.gerenciadordeaulas.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.seducapp.gerenciadordeaulas.model.Usuario;
import com.seducapp.gerenciadordeaulas.repository.UsuarioRepository;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    // Busca um usuário pelo CPF
    public Usuario findByCpf(String cpf) {
        return usuarioRepository.findByCpf(cpf);
    }

    // Valida as credenciais do usuário
    public boolean validateCredentials(String cpf, String password) {
        Usuario usuario = usuarioRepository.findByCpf(cpf);
        if (usuario == null) {
            throw new UsernameNotFoundException("Usuário não encontrado com o CPF: " + cpf);
        }
        return passwordEncoder.matches(password, usuario.getPassword());
    }
}


