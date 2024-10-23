package com.seducapp.gerenciadordeaulas.controllers;

import com.seducapp.gerenciadordeaulas.model.Usuario;
import com.seducapp.gerenciadordeaulas.services.UsuarioService;
import com.seducapp.gerenciadordeaulas.dto.LoginDTO; 
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
    public ResponseEntity<Usuario> buscarPorCpf(@PathVariable String cpf) {
        Usuario usuario = usuarioService.findByCpf(cpf);
        if (usuario == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(usuario);
    }

    // Endpoint para login/validação de credenciais
    @PostMapping("/login")
    public ResponseEntity<String> validarCredenciais(@RequestParam String cpf, @RequestParam String password) {
        try {
            boolean isValid = usuarioService.validateCredentials(cpf, password);
            return ResponseEntity.ok("Credenciais válidas.");
        } catch (UsernameNotFoundException e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Usuário não encontrado.");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Erro ao validar credenciais.");
        }

    }
}
