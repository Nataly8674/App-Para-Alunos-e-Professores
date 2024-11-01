package com.seducapp.gerenciadordeaulas.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import com.seducapp.gerenciadordeaulas.repository.UsuarioRepository;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public UserDetails loadUserByUsername(String cpf) throws UsernameNotFoundException {
        return usuarioRepository.findByCpf(cpf)
            .orElseThrow(() -> new UsernameNotFoundException("Usuário não encontrado com o CPF: " + cpf));
    }
}