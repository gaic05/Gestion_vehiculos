package com.example.repuesto.dto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RepuestoResponse {

    private Long codRepuesto;
    private String nombre;
    private Long valor;
}