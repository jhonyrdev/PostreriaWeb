package com.postreria.server.Modules.ventas.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.postreria.server.Modules.ventas.Entity.MetodoPago;

@Repository
public interface MetodoPagoRepository extends JpaRepository<MetodoPago, Integer> {
    MetodoPago findByTipoPago(String tipoPago);
}
