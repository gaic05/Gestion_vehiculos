package com.example.repuesto.exception;

public class RepuestoNotFoundException extends RuntimeException {
    public RepuestoNotFoundException(Long id) {
        super("No se encontró ningún repuesto con ID: " + id);
    }
}
