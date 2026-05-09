package com.example.reparaciones.dto;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReparacionesRequest {

    @NotNull(message = "Debe ingresar un id de reparaciones")
    private Long id;

    @NotNull(message = "Debe ingresar el id del tecnico")
    private Long tecnicoId;

    @NotNull(message = "Debe ingresar el id de la solicitud")
    private Long solicitudId;

    @NotBlank(message = "Debe agregar la desripcion")
    private String descripcion;

    @NotNull(message = "El precio es obligatorio")
    @DecimalMin(value = "0.1", message = "El precio debe ser mayor a 0")
    private double costo;

    @NotNull(message = "La fecha de reparacion es obligatoria")
    private Date fechaReparacion;
}
