package com.seducapp.gerenciadordeaulas.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.seducapp.gerenciadordeaulas.model.Horario;
import com.seducapp.gerenciadordeaulas.repository.HorarioRepository;

@Service
public class HorarioService {

    @Autowired
    private HorarioRepository horarioRepository;

    // Retorna todos os horários cadastrados
    public List<Horario> findAll() {
        return horarioRepository.findAll();
    }

    // Retorna um horário pelo ID
    public Horario findById(Long id_horario) {
        return horarioRepository.findById(id_horario).orElse(null);
    }

    // Registra ou atualiza um horário
    public Horario save(Horario horario) {
        return horarioRepository.save(horario);
    }

    // Remove um horário pelo ID
    public void delete(Long id_horario) {
        horarioRepository.deleteById(id_horario);
    }
}

