package com.example.vehiculo.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "vehiculos")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Vehiculo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column (nullable = false, unique = true, length = 10)
    private String patente;

    @Column (nullable = false, length = 100)
    private String modelo;

    @Column (nullable = false, length = 100)
    private String color;

    @Column (nullable = false, unique = true, length = 100)
    private String vin;

    @Column (nullable = false)
    private int annio;

    @Column (nullable = false, length = 100)
    private Long usuarioId;

    @ManyToOne
    @JoinColumn(name = "marca_id")
    private MarcaVehiculo marcaVehiculo;
}
