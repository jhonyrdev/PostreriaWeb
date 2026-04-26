package com.postreria.server.Modules.ventas.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.postreria.server.Commons.exception.badRequestException;
import com.postreria.server.Commons.exception.resourceNotFoundException;
import com.postreria.server.Modules.ventas.Dto.BuscarFacturaDTO;
import com.postreria.server.Modules.ventas.Repository.FacturaRepository;

import lombok.*;

@RequiredArgsConstructor
@Service
public class FacturaServicio {

    private final FacturaRepository facrepo;

    public List<BuscarFacturaDTO> buscarFac(String nfac){
        if (nfac == null || nfac.isBlank()) {
            throw new badRequestException("El numero de factura es obligatorio");
        }

        List<BuscarFacturaDTO> facturas = facrepo.buscarFac(nfac);
        if (facturas == null || facturas.isEmpty()) {
            throw new resourceNotFoundException("No se encontraron facturas para el criterio enviado");
        }

        return facturas;
    }
}
