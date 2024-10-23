package com.seducapp.gerenciadordeaulas.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.seducapp.gerenciadordeaulas.model.Conteudo_ministrado;
import com.seducapp.gerenciadordeaulas.repository.Conteudo_ministradoRepository;

@Service
public class Conteudo_ministradoService {

    @Autowired
    private Conteudo_ministradoRepository conteudoMinistradoRepository;

    // Retorna todos os conteúdos ministrados cadastrados
    public List<Conteudo_ministrado> findAll() {
        return conteudoMinistradoRepository.findAll();
    }

    // Retorna um conteúdo ministrado pelo ID
    public Conteudo_ministrado findById(Long id_conteudo) {
        return conteudoMinistradoRepository.findById(id_conteudo).orElse(null);
    }

    // Registra ou atualiza um conteúdo ministrado
    public Conteudo_ministrado save(Conteudo_ministrado conteudoMinistrado) {
        return conteudoMinistradoRepository.save(conteudoMinistrado);
    }

    // Remove um conteúdo ministrado pelo ID
    public void delete(Long id_conteudo) {
        conteudoMinistradoRepository.deleteById(id_conteudo);
    }
}
