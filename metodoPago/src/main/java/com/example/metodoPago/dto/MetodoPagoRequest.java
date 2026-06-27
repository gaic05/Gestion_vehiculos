package com.example.metodoPago.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.util.Date;

@Data
public class MetodoPagoRequest {

    private Double valorRepuesto;

    private Double manoObra;

    private Date fechaEmision;

    @NotBlank(message = "El modo de pago es obligatorio")
    private String modoPago;
}
