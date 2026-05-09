package com.example.repuesto.model;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "respuestos")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class Repuesto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idRepuesto;

    @Column(nullable = false, unique = true, length = 20)
    private Long codRepuesto;

    @Column(nullable = false, length = 255)
    private String nombre;

    @Column(name = "valor", nullable = false)
    private Long valor;
}
