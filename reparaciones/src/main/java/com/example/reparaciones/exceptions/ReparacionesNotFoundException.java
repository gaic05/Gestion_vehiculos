package com.example.reparaciones.exceptions;

public class ReparacionesNotFoundException extends RuntimeException {
    public ReparacionesNotFoundException(Long id) {
        super("Reparacion no encontrada con id: " + id);
    }
}
