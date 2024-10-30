package com.seducapp.gerenciadordeaulas.services;

import com.seducapp.gerenciadordeaulas.model.Usuario;
import com.seducapp.gerenciadordeaulas.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService implements UserDetailsService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private PasswordEncoder passwordEncoder; // Não deve causar ciclo agora

    // Método para buscar um usuário pelo CPF
    public Usuario findByCpf(String cpf) {
        return usuarioRepository.findByCpf(cpf);
    }

    // Método necessário para UserDetailsService
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Usuario usuario = usuarioRepository.findByCpf(username); // Ou use username como email
        if (usuario == null) {
            throw new UsernameNotFoundException("Usuário não encontrado");
        }
        return usuario; // Retorna o usuário que implementa UserDetails
    }

    // Valida as credenciais do usuário
    public boolean validateCredentials(String cpf, String senha) {
        Usuario usuario = usuarioRepository.findByCpf(cpf); // Busca o usuário pelo CPF
        if (usuario == null) {
            throw new UsernameNotFoundException("Usuário não encontrado");
        }

        // Verifica se a senha bate (senha no banco está criptografada)
        return passwordEncoder.matches(senha, usuario.getPassword()); // Compara a senha
    }
}





