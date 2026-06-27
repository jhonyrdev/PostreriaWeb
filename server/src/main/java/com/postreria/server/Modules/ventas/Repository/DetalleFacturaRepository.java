package com.postreria.server.Modules.ventas.Repository;
import java.util.List;

import org.springframework.data.jpa.repository.*;
import org.springframework.data.repository.query.Param;

import com.postreria.server.Modules.ventas.Entity.DetalleFactura;

public interface DetalleFacturaRepository extends JpaRepository<DetalleFactura, Integer> {
    @Query("SELECT d FROM DetalleFactura d WHERE d.nFac = :nFac")
    List<DetalleFactura> buscarPorFactura(@Param("nFac") Integer nFac);
}
