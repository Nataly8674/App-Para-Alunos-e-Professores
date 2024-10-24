package com.seducapp.gerenciadordeaulas.services;

import java.util.List;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.seducapp.gerenciadordeaulas.model.Usuario;
import com.seducapp.gerenciadordeaulas.repository.UsuarioRepository;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    private final UsuarioRepository usuarioRepository;

    public CustomUserDetailsService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String cpf) throws UsernameNotFoundException {
        Usuario usuario = usuarioRepository.findByCpf(cpf);
        
        if (usuario == null) {
            throw new UsernameNotFoundException("Usuário não encontrado com CPF: " + cpf);
        }

        return User.builder()
                .username(usuario.getCpf())
                .password(usuario.getSenha())
                .authorities(List.of(new SimpleGrantedAuthority(usuario.getTipo_usuario().name())))
                .build();
    }
}