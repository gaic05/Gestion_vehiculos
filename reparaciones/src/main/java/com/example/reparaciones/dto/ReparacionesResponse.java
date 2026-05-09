package com.example.reparaciones.dto;

import lombok.Builder;
import lombok.Data;
import java.util.Date;

@Data
@Builder
public class ReparacionesResponse {
    private Long id;
    private Long tecnicoId;
    private Long solicitudId;
    private String descripcion;
    private double costo;
    private Date fechaReparacion;
}
