package com.example.vehiculo.exception;

public class PatenteDuplicadoException extends RuntimeException {

    public PatenteDuplicadoException(String patente, String existente) {

        super("La patente " + patente +
                " ya está registrada en el sistema");
    }
}
