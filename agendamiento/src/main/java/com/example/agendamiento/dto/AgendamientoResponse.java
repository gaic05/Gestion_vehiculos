package com.example.agendamiento.dto;

import lombok.Builder;
import lombok.Data;
import java.time.LocalDateTime;

@Data
@Builder
public class AgendamientoResponse {
    private Long id;
    private Long vehiculoId;
    private Long usuarioId;
    private LocalDateTime fechaHora;
    private String estado;
    private String descripcion;
}
