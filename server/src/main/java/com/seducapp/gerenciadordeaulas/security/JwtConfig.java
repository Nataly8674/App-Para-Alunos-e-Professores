package com.seducapp.gerenciadordeaulas.security;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "jwt")
public class JwtConfig {
    private String secret = "$2a$12$JIHHwLj8NNtrTE044Ss0o.JSK1vzBDabrQYnuE9.PcTSfDk41aCAi";
    private long expiration = 86400000; // 1 dia em millisegundos

    public String getSecret() {
        return secret;
    }

    public void setSecret(String secret) {
        this.secret = secret;
    }

    public long getExpiration() {
        return expiration;
    }

    public void setExpiration(long expiration) {
        this.expiration = expiration;
    }
}
