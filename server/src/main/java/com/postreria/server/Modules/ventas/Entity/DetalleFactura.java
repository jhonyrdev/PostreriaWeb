package com.postreria.server.Modules.ventas.Entity;

import jakarta.persistence.*;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "DETALLE_FACTURA")
public class DetalleFactura {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_DETALLE")
    private Integer idDetalle;

    @Column(name = "N_FAC")
    private Integer nFac;   // FK hacia Factura

    @Column(name = "ID_PRODUCTO")
    private Integer idProducto;  // FK hacia Producto

    @Column(name = "CANTIDAD")
    private Integer cantidad;

    @Column(name = "PRECIO_UNITARIO")
    private Double precioUnitario;

    
}

