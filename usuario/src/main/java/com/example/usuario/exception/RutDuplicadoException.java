package com.example.usuario.exception;

public class RutDuplicadoException extends RuntimeException {

    public RutDuplicadoException(Long rut, String nombre) {
        super("Ya existe un usuario registrado con el RUT: " + rut + ", el nombre del usuario es '" + nombre + "'");
    }
}
