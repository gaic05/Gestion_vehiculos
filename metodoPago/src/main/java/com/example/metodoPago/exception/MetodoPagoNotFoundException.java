package com.example.metodoPago.exception;

public class MetodoPagoNotFoundException extends RuntimeException {
    public MetodoPagoNotFoundException(Long id) {
        super("Método de pago no encontrado con id: " + id);
    }
}
