package com.seducapp.gerenciadordeaulas.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import com.seducapp.gerenciadordeaulas.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    Optional<Usuario> findByCpf(String cpf);
}
