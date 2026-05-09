package com.example.usuario.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "usuarios")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 255)
    private String contrasenia;

    @Column(nullable = false, length = 150)
    private  String nombre;

    @Column(nullable = false, length = 150)
    private String apPaterno;

    @Column(nullable = false, length = 150)
    private String apMaterno;

    @Column(nullable = false)
    private Long rut;

    @Column(nullable = false, length = 1)
    private String dv;

    @Column(nullable = false, length = 12)
    private String telefono;

    @Column(nullable = false, length = 255)
    private String email;

    @ManyToOne
    @JoinColumn(name = "tipo_usuario_id")
    private TipoUsuario tipoUsuario;

}