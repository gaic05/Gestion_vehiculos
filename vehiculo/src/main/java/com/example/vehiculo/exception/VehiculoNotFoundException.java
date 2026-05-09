package com.example.vehiculo.exception;

public class VehiculoNotFoundException extends RuntimeException {
    public VehiculoNotFoundException(String patente) {
        super("No se encontro el vehiculo con la patente: "+ patente);
    }
}
