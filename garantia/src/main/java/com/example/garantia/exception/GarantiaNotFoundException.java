package com.example.garantia.exception;

public class GarantiaNotFoundException extends RuntimeException {

    public GarantiaNotFoundException(Long id) {
        super("Garantía no encontrada con id: " + id);
    }
}
