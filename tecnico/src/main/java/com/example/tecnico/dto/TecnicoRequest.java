package com.example.tecnico.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TecnicoRequest {

    @NotBlank(message = "El nombre es obligatorio")
    private String nombre;

    @NotBlank(message = "La especialidad es obligatoria")
    private String especialidad;

    @NotBlank(message = "Debe ingresar un numero telefonico")
    @Pattern(regexp = "^\\+[0-9]{9,12}$", message = "El teléfono debe ser formato valido +56912345678")
    private String telefono;

    @Email
    private String email;

}
