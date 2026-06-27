package com.example.metodoPago.model;

import jakarta.persistence.*;
import lombok.*;
import java.util.Date;

@Entity
@Table(name = "metodo_pago")

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class MetodoPago {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "valor_repuesto")
    private Double valorRepuesto;

    @Column(name = "mano_obra")
    private Double manoObra;

    private Double total;

    @Temporal(TemporalType.DATE)
    @Column(name = "fecha_emision")
    private Date fechaEmision;

    @Column(name = "modo_pago", nullable = false, length = 15)
    private String modoPago;

    @PrePersist
    @PreUpdate
    public void calcularTotal() {

        double repuesto = valorRepuesto != null
                ? valorRepuesto
                : 0;

        double mano = manoObra != null
                ? manoObra
                : 0;

        this.total = repuesto + mano;
    }
}
