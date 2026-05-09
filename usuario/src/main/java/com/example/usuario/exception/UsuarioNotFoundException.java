package com.example.usuario.exception;

public class UsuarioNotFoundException extends RuntimeException {
    public UsuarioNotFoundException(Long rut) {
        super("No se encontro el usuario con el rut: " + rut);
    }
}
