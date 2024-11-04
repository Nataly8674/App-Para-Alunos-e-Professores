package com.seducapp.gerenciadordeaulas.controllers;

import com.seducapp.gerenciadordeaulas.model.Usuario;
import com.seducapp.gerenciadordeaulas.services.UsuarioService;
import com.seducapp.gerenciadordeaulas.dto.LoginDTO; 
import jakarta.validation.Valid;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    // Endpoint para buscar usuário por CPF
    @GetMapping("/{cpf}")
    public ResponseEntity<Optional<Usuario>> buscarPorCpf(@PathVariable String cpf) {
        Optional<Usuario> usuario = usuarioService.findByCpf(cpf);
        if (usuario == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(usuario);
    }

    // Endpoint para login/validação de credenciais
    @PostMapping("/login")
    public ResponseEntity<String> validarCredenciais(@Valid @RequestBody LoginDTO loginDTO) {
        try {
            // Valida as credenciais
            boolean isValid = usuarioService.validateCredentials(loginDTO.getCpf(), loginDTO.getPassword());
            if (isValid) {
                return ResponseEntity.ok("Credenciais válidas.");
            } else {
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Credenciais inválidas.");
            }
        } catch (UsernameNotFoundException e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Usuário não encontrado.");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro ao validar credenciais.");
        }
    }
}



