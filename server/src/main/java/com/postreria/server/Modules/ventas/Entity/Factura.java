package com.postreria.server.Modules.ventas.Entity;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "FACTURA")
public class Factura {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    @Column(name = "N_FAC")
    private Integer nFac;

    @Column(name = "FECHA_FAC")
    private LocalDate fecha; 

    @Column(name = "ID_CLIENTE")
    private Integer idCliente;

    @Column(name = "ID_PAGO")
    private Integer idPago;
    
}
