package com.example.garantia.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GarantiaRequest {

    @NotNull(message = "La fecha de inicio es obligatoria")
    private Date fechaInicio;

    @NotNull(message = "La fecha de termino es obligatoria")
    private Date fechaFin;

    @NotBlank(message = "Ingrese tipo de garantia")
    private String tipoGarantia;

    @NotBlank(message = "Ingrese el estado")
    private String estado;

}
