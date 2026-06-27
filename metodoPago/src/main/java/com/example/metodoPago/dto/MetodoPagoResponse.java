package com.example.metodoPago.dto;

import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@Builder
public class MetodoPagoResponse {

    private Long id;

    private Double valorRepuesto;

    private Double manoObra;

    private Double total;

    private Date fechaEmision;

    private String modoPago;
}
