package com.postreria.server.Modules.ventas.Entity;

import jakarta.persistence.*;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "METODO_PAGO")
public class MetodoPago {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_PAGO")
    private Integer idPago;

    @Column(name = "TIPO_PAGO")
    private String tipoPago;

}