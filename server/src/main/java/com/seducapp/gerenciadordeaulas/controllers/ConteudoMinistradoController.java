package com.seducapp.gerenciadordeaulas.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.seducapp.gerenciadordeaulas.dto.ConteudoMinistradoRequestDTO;
import com.seducapp.gerenciadordeaulas.dto.ConteudoMinistradoResponseDTO;
import com.seducapp.gerenciadordeaulas.services.Conteudo_ministradoService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/conteudos")
public class ConteudoMinistradoController {
    
    @Autowired
    private Conteudo_ministradoService service;
    
    @GetMapping
    public ResponseEntity<List<ConteudoMinistradoResponseDTO>> findAll() {
        List<ConteudoMinistradoResponseDTO> list = service.findAll();
        return ResponseEntity.ok(list);
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<ConteudoMinistradoResponseDTO> findById(@PathVariable Long id) {
        ConteudoMinistradoResponseDTO dto = service.findById(id);
        return ResponseEntity.ok(dto);
    }
    
    @PostMapping
    public ResponseEntity<ConteudoMinistradoResponseDTO> create(@Valid @RequestBody ConteudoMinistradoRequestDTO dto) {
        ConteudoMinistradoResponseDTO responseDTO = service.create(dto);
        var uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(responseDTO.getId()).toUri();
        return ResponseEntity.created(uri).body(responseDTO);
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<ConteudoMinistradoResponseDTO> update(
            @PathVariable Long id,
            @Valid @RequestBody ConteudoMinistradoRequestDTO dto) {
        ConteudoMinistradoResponseDTO responseDTO = service.update(id, dto);
        return ResponseEntity.ok(responseDTO);
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}