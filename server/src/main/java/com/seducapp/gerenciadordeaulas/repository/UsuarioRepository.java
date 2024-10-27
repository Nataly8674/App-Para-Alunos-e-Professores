package com.seducapp.gerenciadordeaulas.repository;

import com.seducapp.gerenciadordeaulas.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    Usuario findByCpf(String cpf); // Método para buscar o usuário pelo CPF
}
