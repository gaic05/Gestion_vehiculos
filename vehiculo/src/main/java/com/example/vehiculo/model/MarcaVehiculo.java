package com.example.vehiculo.model;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "marca_vehiculo")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MarcaVehiculo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column (nullable = false, unique = true, length = 10)
    private String patente;

    @OneToMany(mappedBy = "marcaVehiculo")
    private List<Vehiculo> vehiculos;

}
