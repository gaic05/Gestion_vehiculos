package com.example.vehiculo.dto;
import com.example.vehiculo.model.MarcaVehiculo;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VehiculoRequest {

    @NotBlank(message = "La patente es obligatoria")
    private String patente;

    @NotBlank(message = "El modelo es obligatorio")
    private String modelo;

    @NotBlank(message = "Ingrese el color")
    private String color;

    @NotBlank(message = "Ingrese el vin del vehiculo")
    private String vin;

    @NotBlank(message = "Ingrese el año del vehiculo")
    private int annio;

    @NotNull(message = "Debe ingresar la marca del vehiculo")
    private MarcaVehiculo marcaVehiculo;

}
