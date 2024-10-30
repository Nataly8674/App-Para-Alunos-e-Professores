package com.seducapp.gerenciadordeaulas.dto;

import java.time.LocalDate;
import java.util.List;

public class RealizarChamadaRequestDTO {
    private Long idHorario;
    private LocalDate data;
    private List<PresencaAlunoDTO> presencas;

    // Getters e Setters
    public Long getIdHorario() { return idHorario; }
    public void setIdHorario(Long idHorario) { this.idHorario = idHorario; }
    public LocalDate getData() { return data; }
    public void setData(LocalDate data) { this.data = data; }
    public List<PresencaAlunoDTO> getPresencas() { return presencas; }
    public void setPresencas(List<PresencaAlunoDTO> presencas) { this.presencas = presencas; }
}
