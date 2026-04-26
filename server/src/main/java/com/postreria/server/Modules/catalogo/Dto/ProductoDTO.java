package com.postreria.server.Modules.catalogo.Dto;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductoDTO {
    private int id;       
    private String nombre;  
    private int cantidad;
    private double precio;  

}
