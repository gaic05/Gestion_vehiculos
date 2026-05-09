package com.example.agendamiento.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class AgendamientoRequest {
    @NotNull(message = "Debe ingresar el id del agendamiento")
    private Long id;

    @NotNull(message = "Debe ingresar el id del vehiculo")
    private Long vehiculoId;

    @NotNull(message = "Debe ingresar el id del usuario")
    private Long usuarioId;

    private Date fechaHora;

    @NotBlank(message = "Debe agregar una descripcion")
    private String descripcion;
}
