package com.postreria.server.Modules.catalogo.Entity;

import jakarta.persistence.*;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="PRODUCTO")
public class Producto {
    
    @Id
    @Column(name="ID_PRODUCTO")
    Integer idProducto;
    @Column(name="NOM_PRODUCTO")
    String nomProducto;

}
