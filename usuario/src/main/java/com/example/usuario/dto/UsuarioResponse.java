package com.example.usuario.dto;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UsuarioResponse {

    private Long id;
    private String nombre;
    private String email;
    private Long rut;
    private String tipo;
}
