package com.seducapp.gerenciadordeaulas.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.seducapp.gerenciadordeaulas.dto.AuthRequest;
import com.seducapp.gerenciadordeaulas.dto.AuthResponse;
import com.seducapp.gerenciadordeaulas.model.Usuario;
import com.seducapp.gerenciadordeaulas.security.JwtTokenProvider;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtTokenProvider tokenProvider;

    @PostMapping("/login")
    public ResponseEntity<?> authenticateUser(@RequestBody AuthRequest loginRequest) {
        Authentication authentication = authenticationManager.authenticate(
            new UsernamePasswordAuthenticationToken(
                loginRequest.getCpf(),
                loginRequest.getSenha()
            )
        );

        SecurityContextHolder.getContext().setAuthentication(authentication);
        Usuario usuario = (Usuario) authentication.getPrincipal();
        String jwt = tokenProvider.generateToken(authentication);

        return ResponseEntity.ok(new AuthResponse(jwt, 
                               usuario.getTipo_usuario().name(), 
                               usuario.getNome()));
    }
}
