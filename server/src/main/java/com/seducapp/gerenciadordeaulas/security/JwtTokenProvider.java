package com.seducapp.gerenciadordeaulas.security;

import io.jsonwebtoken.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;
import com.seducapp.gerenciadordeaulas.model.Usuario;

import java.util.Date;
import java.util.Base64;

@Component
public class JwtTokenProvider {

    @Autowired
    private JwtConfig jwtConfig;

    public String generateToken(Authentication authentication) {
        Usuario userPrincipal = (Usuario) authentication.getPrincipal();
        Date now = new Date();
        Date expiryDate = new Date(now.getTime() + jwtConfig.getExpiration());

        return Jwts.builder()
                .setSubject(userPrincipal.getUsername())
                .claim("tipo", userPrincipal.getTipo_usuario().name())
                .setIssuedAt(now)
                .setExpiration(expiryDate)
                .signWith(SignatureAlgorithm.HS512, Base64.getEncoder().encodeToString(jwtConfig.getSecret().getBytes()))
                .compact();
    }

    public String getCpfFromToken(String token) {
        Claims claims = Jwts.parser()
                .setSigningKey(Base64.getDecoder().decode(jwtConfig.getSecret()))
                .parseClaimsJws(token)
                .getBody();
        return claims.getSubject();
    }

    public boolean validateToken(String token) {
        try {
            Jwts.parser().setSigningKey(Base64.getDecoder().decode(jwtConfig.getSecret())).parseClaimsJws(token);
            return true;
        } catch (JwtException | IllegalArgumentException e) {
            return false;
        }
    }
}
