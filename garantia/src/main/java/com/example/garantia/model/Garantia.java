package com.example.garantia.model;

import jakarta.persistence.*;
import lombok.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Entity
@Table(name= "garantias")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Garantia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Date fechaInicio;

    @Column(nullable = false)
    private Date fechaFin;

    @Column (nullable = false, length = 50)
    private String tipoGarantia;

    @Column (nullable = false, length = 50)
    private String estado;

    @Column (nullable = false, length = 100)
    private Long vehiculoId;
}
