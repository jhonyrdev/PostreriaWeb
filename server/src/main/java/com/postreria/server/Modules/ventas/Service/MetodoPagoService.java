package com.postreria.server.Modules.ventas.Service;

import org.springframework.stereotype.Service;

import com.postreria.server.Modules.ventas.Entity.MetodoPago;
import com.postreria.server.Modules.ventas.Repository.MetodoPagoRepository;

import lombok.*;

@RequiredArgsConstructor
@Service
public class MetodoPagoService {

    private MetodoPagoRepository metodoPagoRepository;

    public int obtenerIdPorTipo(String tipoPago) {
        MetodoPago metodo = metodoPagoRepository.findByTipoPago(tipoPago);
        if (metodo == null) {
            metodo = new MetodoPago();
            metodo.setTipoPago(tipoPago);
            metodo = metodoPagoRepository.save(metodo);
        }
        return metodo.getIdPago();
    }
}
