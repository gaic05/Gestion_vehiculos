package com.example.vehiculo.dto;
import lombok.Builder;
import lombok.Data;
@Data
@Builder

public class VehiculoResponse {
    private Long id;
    private String patente;
    private String modelo;
    private String color;
    private String vin;
    private int annio;
    private String marcaVehiculo;

}
