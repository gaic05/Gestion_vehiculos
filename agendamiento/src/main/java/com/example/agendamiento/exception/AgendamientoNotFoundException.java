package com.example.agendamiento.exception;

public class AgendamientoNotFoundException extends RuntimeException {
    public AgendamientoNotFoundException(Long id) {
        super("El agendamiento no fue encontrado con id: "+id);
    }
}
