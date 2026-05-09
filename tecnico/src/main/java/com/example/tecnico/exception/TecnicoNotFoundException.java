package com.example.tecnico.exception;

public class TecnicoNotFoundException extends RuntimeException {

    public TecnicoNotFoundException(Long id) {
        super("Técnico no encontrado con id: " + id);
    }
}
