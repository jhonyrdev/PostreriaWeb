package com.postreria.server.Modules.ventas.Dto;

public interface BuscarFacturaDTO {
    String getFecha();
    String getNombre();
    String getNomProducto();
    Integer getCantidad();
    Double getPrecioUnitario();
    Double getSubtotal();
}
