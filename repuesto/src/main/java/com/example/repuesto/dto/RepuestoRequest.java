package com.example.repuesto.dto;
import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class RepuestoRequest {

    @NotBlank(message = "El codigo del repuesto es obligatorio")
    private Long codRepuesto;

    @NotBlank(message = "El nombre es obligatorio")
    @Size(min = 1, max = 50, message = "El nombre debe tener entre 1 y 50 caracteres")
    private String nombre;

    @NotBlank(message = "El valor es obligatorio")
    private Long valor;
}
