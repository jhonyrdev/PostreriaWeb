package com.postreria.server.Modules.ventas.Repository;

import java.util.*;

import org.springframework.data.jpa.repository.*;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.postreria.server.Modules.ventas.Dto.BuscarFacturaDTO;
import com.postreria.server.Modules.ventas.Entity.Factura;

@Repository
public interface FacturaRepository extends JpaRepository<Factura, Integer> {
    Factura findByIdCliente(Integer idCliente);

    @Query(value = "SELECT * FROM buscarFac(:nfac)", nativeQuery = true)
    List<BuscarFacturaDTO> buscarFac(@Param("nfac") String nfac);
}