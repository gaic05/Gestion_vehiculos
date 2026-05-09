package com.example.garantia.dto;

import lombok.Builder;
import lombok.Data;
import java.util.Date;

@Data
@Builder
public class GarantiaResponse {
    private Long id;
    private Date fechaInicio;
    private Date fechaFin;
    private String tipoGarantia;
    private String estado;
    private Long vehiculoId;
}
